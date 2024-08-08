package br.com.alura.integration;

import br.com.alura.env.EnvironmentVariable;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.completion.chat.ChatMessageRole;
import com.theokanning.openai.service.OpenAiService;

import java.time.Duration;
import java.util.Arrays;

public class OpenAI {

    public static void execute(Model model, String user, String system) {
        System.out.println("Modelo: " + model.getName());

        var token = EnvironmentVariable.getOpenAIApiKey();

        var duration = EnvironmentVariable.getOpenAIDuration();

        var maxTokens = EnvironmentVariable.getOpenAIMaxTokens();

        var service = new OpenAiService(token, Duration.ofSeconds(duration));

        var completionRequest = ChatCompletionRequest
                .builder()
                .model(model.getName())
                .maxTokens(maxTokens) //tamanho máximo de tokens que a resposta gerada pode conter
                .messages(Arrays.asList(
                        new ChatMessage(ChatMessageRole.SYSTEM.value(), system),
                        new ChatMessage(ChatMessageRole.USER.value(), user)
                ))
                .n(1) //número de respostas
                .build();

        service
                .createChatCompletion(completionRequest)
                .getChoices()
                .forEach(c -> System.out.println(c.getMessage().getContent()));
    }

}
