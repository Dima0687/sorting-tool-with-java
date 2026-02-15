package de.eisner.sorting.pipeline;

import java.util.List;

/**
 * Represents an ordered sequence of processing steps.
 *
 * <p>A pipeline executes each {@link Step} sequentially,
 * passing the same {@link Context} instance to every step.
 *
 * @param <T> the type of elements being processed
 */
public class Pipeline<T extends Comparable<T>> {

    private final List<Step<T>> pipeline;

    /**
     * Creates a new pipeline with the given ordered steps.
     *
     * @param pipeline the list of processing steps
     */
    public Pipeline(List<Step<T>> pipeline) {
        this.pipeline = pipeline;
    }

    /**
     * Executes all pipeline steps in their defined order.
     *
     * @param context the shared execution context
     */
    public  void run(Context<T> context) {
        pipeline.forEach(step -> step.execute(context));
    }
}
