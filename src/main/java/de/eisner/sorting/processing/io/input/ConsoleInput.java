package de.eisner.sorting.processing.io.input;

import de.eisner.sorting.pipeline.Context;
import de.eisner.sorting.pipeline.Step;

import java.util.Scanner;

/**
 * Pipeline step that initializes console-based input.
 *
 * <p>This step assigns a {@link java.util.Scanner}
 * reading from {@link System#in} to the context.
 *
 * @param <T> the type of elements being processed
 */
public class ConsoleInput<T extends Comparable<T>> implements Step<T> {

    /**
     * Initializes a scanner reading from standard input.
     *
     * @param context the shared execution context
     */
    @Override
    public void execute(Context<T> context) {
        Scanner scanner = new Scanner(System.in);
        context.setScanner(scanner);
    }
}
