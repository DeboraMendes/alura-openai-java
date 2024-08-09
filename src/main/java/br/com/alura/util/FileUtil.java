package br.com.alura.util;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Set;
import java.util.stream.Collectors;

public class FileUtil {

    private final static String DIRECTORY = "src/main/resources/";

    public static String loadContent(String folderName, String fileName) {
        try {
            var path = Path.of(ClassLoader.getSystemResource(folderName + "/" + fileName).toURI());
            return FileUtil.readFile(path);
        } catch (Exception e) {
            throw new RuntimeException("Error loading from file", e);
        }
    }

    public static String readFile(Path path) {
        try {
            return Files.readAllLines(path).toString();
        } catch (Exception e) {
            throw new RuntimeException("Error loading from file", e);
        }
    }

    public static Set<Path> loadFile(String folderName, String fileType) {
        try {
            return Files
                    .walk(Path.of(DIRECTORY + folderName), 1)
                    .filter(path -> path.toString().endsWith(fileType))
                    .collect(Collectors.toSet());
        } catch (Exception e) {
            throw new RuntimeException("Error loading file", e);
        }
    }

    public static void saveFile(String folderName, String fileName, String fileContent) {
        try {
            var path = Path.of(DIRECTORY + folderName + "/ " + fileName);
            Files.writeString(path, fileContent, StandardOpenOption.CREATE_NEW);
            System.out.println("Saved file: " + fileName);
        } catch (Exception e) {
            throw new RuntimeException("Error saving file", e);
        }
    }

}

