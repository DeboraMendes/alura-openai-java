package br.com.alura.integration;

import br.com.alura.env.EnvironmentVariable;
import com.theokanning.openai.OpenAiHttpException;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.completion.chat.ChatMessageRole;
import com.theokanning.openai.service.OpenAiService;

import java.time.Duration;
import java.util.Arrays;

public class OpenAI {

    public static String getResponse(Model model, String system, String user) {
        System.out.println("Realizando integração com a API da OpenAI: " + model.getName());

        var token = EnvironmentVariable.getOpenAIApiKey();

        var duration = EnvironmentVariable.getOpenAIDuration();

        var maxTokens = EnvironmentVariable.getOpenAIMaxTokens();

        var service = new OpenAiService(token, Duration.ofSeconds(duration));

        var request = ChatCompletionRequest
                .builder()
                .model(model.getName())
                .maxTokens(maxTokens) //tamanho máximo de tokens que a resposta gerada pode conter
                .messages(Arrays.asList(
                        new ChatMessage(ChatMessageRole.SYSTEM.value(), system),
                        new ChatMessage(ChatMessageRole.USER.value(), user)
                ))
                .n(1) //número de respostas
                .build();

        var attempts = 0;
        var secondForNextAttempt = 5;
        while (attempts++ != 5) {
            try {
                return service
                        .createChatCompletion(request)
                        .getChoices()
                        .get(0).
                        getMessage()
                        .getContent();
            } catch (OpenAiHttpException openAiHttpException) {
                var errorCode = openAiHttpException.statusCode;
                switch (errorCode) {
                    case 401 -> throw new RuntimeException("Erro relacionado a API Key da OpenAI", openAiHttpException);
                    case 429 -> {
                        try {
                            System.out.println("Limite de taxa atingido. Nova tentativa em instantes");
                            Thread.sleep(1000L * secondForNextAttempt);
                            secondForNextAttempt *= 2; //Implementar backoff exponencial faz com que a aplicação espere mais tempo entre tentativas após um erro de rate limit, prevenindo bloqueios pela API.
                        } catch (Exception e) {
                            throw new RuntimeException("Limite de taxa atingido. Erro ao aguardar para próxima tentativa", e);
                        }
                    }
                    case 500, 503 -> {
                        try {
                            System.out.println("API da OpenAI fora do ar. Nova tentativa em instantes");
                            Thread.sleep(1000L * secondForNextAttempt);
                        } catch (Exception e) {
                            throw new RuntimeException("API da OpenAI fora do ar. Erro ao aguardar para próxima tentativa", e);
                        }
                    }
                }
            }
        }
        throw new RuntimeException("API da OpenAI fora do ar. Número máximo de tentativas excedido");
    }

}
