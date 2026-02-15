package de.eisner.sorting.processing.sorter;

import de.eisner.sorting.model.Result;
import de.eisner.sorting.pipeline.Context;
import de.eisner.sorting.pipeline.Step;

import java.util.Comparator;

/**
 * Pipeline step that sorts aggregated results
 * by frequency in ascending order.
 *
 * <p>If two entries have the same frequency,
 * they are ordered by their natural value.
 *
 * @param <T> the type of elements being processed
 */
public class ByCountSorter<T extends Comparable<T>> implements Step<T> {

    /**
     * Sorts the result list inside the context.
     *
     * @param context the shared execution context
     */
    @Override
    public void execute(Context<T> context) {
        context.getResults().sort(
                Comparator.<Result<T>>comparingLong(Result::frequency)
                        .thenComparing(Result::dataEntry)
        );
    }
}
