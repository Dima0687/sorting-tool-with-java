package de.eisner.sorting.processing.io.output;

import de.eisner.sorting.pipeline.Context;
import de.eisner.sorting.pipeline.Step;
import de.eisner.sorting.processing.formatter.Formatter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileOutput<T extends Comparable<T>> implements Step<T> {

    private final String fileName;

    public FileOutput(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void execute(Context<T> context) {
        try (PrintWriter writer = new PrintWriter(new File(fileName))) {
            writer.print(Formatter.format(context));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
