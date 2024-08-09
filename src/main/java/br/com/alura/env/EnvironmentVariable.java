package br.com.alura.env;

import java.util.Optional;

public class EnvironmentVariable {

    private static Optional<String> getValue(String name) {
        return Optional.ofNullable(System.getenv(name));
    }

    public static String getOpenAIApiKey() {
        return EnvironmentVariable.getValue("OPENAI_API_KEY")
                .orElseThrow(() -> new RuntimeException("API key not provided"));
    }

    public static Integer getOpenAIDuration() {
        return Integer.parseInt(EnvironmentVariable.getValue("OPENAI_API_DURATION")
                .orElse("60"));
    }

    public static Integer getOpenAIMaxTokens() {
        return Integer.parseInt(EnvironmentVariable.getValue("OPENAI_API_MAX_TOKENS")
                .orElse("2048"));
    }

}
