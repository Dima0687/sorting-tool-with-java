package de.eisner.sorting.pipeline;

public interface Step<T extends Comparable<T>> {
    void execute(Context<T> context);
}
