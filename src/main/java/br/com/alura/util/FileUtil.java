package br.com.alura.util;

import java.nio.file.Files;
import java.nio.file.Path;

public class FileUtil {

    public static String loadFromFile(String name) {
        try {
            var path = Path.of(ClassLoader.getSystemResource(name).toURI());
            return Files.readAllLines(path).toString();
        } catch (Exception e) {
            throw new RuntimeException("Error loading file", e);
        }
    }

}
