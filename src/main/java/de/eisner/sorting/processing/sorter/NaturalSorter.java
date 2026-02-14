package de.eisner.sorting.processing.sorter;

import de.eisner.sorting.pipeline.Context;
import de.eisner.sorting.pipeline.Step;

import java.util.Collections;

public class NaturalSorter<T extends Comparable<T>> implements Step<T> {
    @Override
    public void execute(Context<T> context) {
        Collections.sort(context.getRawInput());
    }
}
