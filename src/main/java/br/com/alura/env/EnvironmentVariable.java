package br.com.alura.env;

import java.util.Optional;

public class EnvironmentVariable {

    public static Optional<String> getValue(String name) {
        return Optional.ofNullable(System.getenv(name));
    }

}
