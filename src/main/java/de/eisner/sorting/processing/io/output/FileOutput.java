package de.eisner.sorting.processing.io.output;

import de.eisner.sorting.pipeline.Context;
import de.eisner.sorting.pipeline.Step;
import de.eisner.sorting.processing.formatter.Formatter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Pipeline step that writes formatted output to a file.
 *
 * @param <T> the type of elements being processed
 */
public class FileOutput<T extends Comparable<T>> implements Step<T> {

    private final String fileName;

    /**
     * Creates a file output step for the given file name.
     *
     * @param fileName the path to the output file
     */
    public FileOutput(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Writes the formatted result to the configured file.
     *
     * @param context the shared execution context
     */
    @Override
    public void execute(Context<T> context) {
        try (PrintWriter writer = new PrintWriter(new File(fileName))) {
            writer.print(Formatter.format(context));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
