package de.eisner.sorting.processing.sorter;

import de.eisner.sorting.pipeline.Context;
import de.eisner.sorting.pipeline.Step;

import java.util.Collections;

/**
 * Pipeline step that sorts raw input data
 * according to their natural order.
 *
 * @param <T> the type of elements being processed
 */
public class NaturalSorter<T extends Comparable<T>> implements Step<T> {

    /**
     * Sorts the raw input list inside the context.
     *
     * @param context the shared execution context
     */
    @Override
    public void execute(Context<T> context) {
        Collections.sort(context.getRawInput());
    }
}
