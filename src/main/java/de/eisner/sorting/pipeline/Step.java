package de.eisner.sorting.pipeline;

/**
 * Represents a single executable unit within the processing pipeline.
 *
 * <p>Each step performs a specific operation on the shared {@link Context}.
 *
 * @param <T> the type of elements being processed
 */
public interface Step<T extends Comparable<T>> {
    /**
     * Executes the step logic using the given context.
     *
     * @param context the shared execution context
     */
    void execute(Context<T> context);
}
