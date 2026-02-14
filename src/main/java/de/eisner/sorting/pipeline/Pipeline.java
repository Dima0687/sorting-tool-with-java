package de.eisner.sorting.pipeline;

import java.util.List;

public class Pipeline<T extends Comparable<T>> {

    private final List<Step<T>> pipeline;

    public Pipeline(List<Step<T>> pipeline) {
        this.pipeline = pipeline;
    }

    public  void run(Context<T> context) {
        pipeline.forEach(step -> step.execute(context));
    }
}
