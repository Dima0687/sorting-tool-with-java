package de.eisner.sorting.processing.io.output;

import de.eisner.sorting.pipeline.Context;
import de.eisner.sorting.pipeline.Step;
import de.eisner.sorting.processing.formatter.Formatter;

/**
 * Pipeline step that writes formatted output to the console.
 *
 * @param <T> the type of elements being processed
 */
public class ConsoleOutput<T extends Comparable<T>> implements Step<T> {

    /**
     * Prints the formatted result to standard output.
     *
     * @param context the shared execution context
     */
    @Override
    public void execute(Context<T> context) {
        System.out.println(Formatter.format(context));
    }
}
