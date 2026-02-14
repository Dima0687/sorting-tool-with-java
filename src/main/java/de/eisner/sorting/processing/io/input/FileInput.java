package de.eisner.sorting.processing.io.input;

import de.eisner.sorting.pipeline.Context;
import de.eisner.sorting.pipeline.Step;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class FileInput<T extends Comparable<T>> implements Step<T> {

    private final Path path;

    public FileInput(String fileName) {
        this.path = Path.of(fileName);
    }

    @Override
    public void execute(Context<T> context) {
        try {
            if (!Files.exists(path)) {
                Files.createFile(path);
            }
            Scanner scanner = new Scanner(path);
            context.setScanner(scanner);
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }
}
