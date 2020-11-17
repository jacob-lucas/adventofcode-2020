package com.jacoblucas.adventofcode2020.utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class InputReader {
    private static final String DEFAULT_PATH = "src/main/resources/";

    public static List<String> read(final String filename) throws IOException {
        return readFile(DEFAULT_PATH, filename);
    }

    public static List<String> readFile(final String path, final String filename) throws IOException {
        return Files.readAllLines(Paths.get(path + filename), StandardCharsets.UTF_8);
    }
}
