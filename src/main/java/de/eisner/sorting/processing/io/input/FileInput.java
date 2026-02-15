package de.eisner.sorting.processing.io.input;

import de.eisner.sorting.pipeline.Context;
import de.eisner.sorting.pipeline.Step;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * Pipeline step that initializes file-based input.
 *
 * <p>If the specified file does not exist, it is created.
 * A {@link java.util.Scanner} is assigned to the context
 * for reading the file content.
 *
 * @param <T> the type of elements being processed
 */
public class FileInput<T extends Comparable<T>> implements Step<T> {

    private final Path path;

    /**
     * Creates a file input step for the given file name.
     *
     * @param fileName the path to the input file
     */
    public FileInput(String fileName) {
        this.path = Path.of(fileName);
    }

    /**
     * Initializes the scanner for file reading.
     *
     * @param context the shared execution context
     */
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
