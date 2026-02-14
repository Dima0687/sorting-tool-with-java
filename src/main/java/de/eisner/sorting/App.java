package de.eisner.sorting;

import de.eisner.sorting.config.ArgumentParser;
import de.eisner.sorting.config.Config;
import de.eisner.sorting.config.SortType;
import de.eisner.sorting.factory.PipelineFactory;
import de.eisner.sorting.pipeline.Context;
import de.eisner.sorting.pipeline.Pipeline;

import java.util.Optional;

public class App {
    public static void main(String[] args) {
        Optional<Config> optionalConfig = ArgumentParser.parse(args);
        if (optionalConfig.isEmpty()) return;

        Config config = optionalConfig.get();

        if (config.sortType() == SortType.BY_COUNT) {
            startPipeline(new Context<Long>(config));
        } else {
            startPipeline(new Context<String>(config));
        }
    }

    private static <T extends Comparable<T>> void startPipeline(Context<T> ctx) {
        Pipeline<T> pipeline = PipelineFactory.create(ctx.getConfig());
        pipeline.run(ctx);
    }
}
