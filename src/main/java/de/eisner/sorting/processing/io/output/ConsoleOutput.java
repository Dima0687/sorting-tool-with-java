package de.eisner.sorting.processing.io.output;

import de.eisner.sorting.pipeline.Context;
import de.eisner.sorting.pipeline.Step;
import de.eisner.sorting.processing.formatter.Formatter;

public class ConsoleOutput<T extends Comparable<T>> implements Step<T> {
    @Override
    public void execute(Context<T> context) {
        System.out.println(Formatter.format(context));
    }
}
