package br.com.alura.integration;

import br.com.alura.env.EnvironmentVariable;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.completion.chat.ChatMessageRole;
import com.theokanning.openai.service.OpenAiService;

import java.time.Duration;
import java.util.Arrays;

public class OpenAI {

    public static void execute(String user, String system) {
        var token = EnvironmentVariable.getValue("OPENAI_API_KEY")
                .orElseThrow(() -> new RuntimeException("API key not provided"));

        var duration = Integer.parseInt(EnvironmentVariable.getValue("OPENAI_API_DURATION").orElse("30"));

        var service = new OpenAiService(token, Duration.ofSeconds(duration));

        var completionRequest = ChatCompletionRequest
                .builder()
                .model("gpt-4")
                .messages(Arrays.asList(
                        new ChatMessage(ChatMessageRole.USER.value(), user),
                        new ChatMessage(ChatMessageRole.SYSTEM.value(), system)
                ))
                .n(1) //número de respostas
                .build();

        service
                .createChatCompletion(completionRequest)
                .getChoices()
                .forEach(c -> System.out.println(c.getMessage().getContent()));
    }

}
