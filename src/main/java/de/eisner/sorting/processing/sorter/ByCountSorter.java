package de.eisner.sorting.processing.sorter;

import de.eisner.sorting.model.Result;
import de.eisner.sorting.pipeline.Context;
import de.eisner.sorting.pipeline.Step;

import java.util.Comparator;

public class ByCountSorter<T extends Comparable<T>> implements Step<T> {
    @Override
    public void execute(Context<T> context) {
        context.getResults().sort(
                Comparator.<Result<T>>comparingLong(Result::frequency)
                        .thenComparing(Result::dataEntry)
        );
    }
}
