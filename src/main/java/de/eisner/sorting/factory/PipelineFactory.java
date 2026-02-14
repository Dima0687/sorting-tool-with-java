package de.eisner.sorting.factory;

import de.eisner.sorting.config.Config;
import de.eisner.sorting.config.SortType;
import de.eisner.sorting.pipeline.Pipeline;
import de.eisner.sorting.pipeline.Step;
import de.eisner.sorting.pipeline.StepType;
import de.eisner.sorting.processing.io.input.ConsoleInput;
import de.eisner.sorting.processing.io.input.FileInput;
import de.eisner.sorting.processing.io.output.ConsoleOutput;
import de.eisner.sorting.processing.io.output.FileOutput;
import de.eisner.sorting.processing.reader.LineReader;
import de.eisner.sorting.processing.reader.NumberReader;
import de.eisner.sorting.processing.reader.WordReader;
import de.eisner.sorting.processing.sorter.ByCountSorter;
import de.eisner.sorting.processing.sorter.NaturalSorter;
import de.eisner.sorting.processing.transform.FrequencyTransformer;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import static de.eisner.sorting.pipeline.StepType.*;

public final class PipelineFactory {

    public static <T extends Comparable<T>> Pipeline<T> create(Config config) {

        EnumSet<StepType> flow = EnumSet.of(INPUT, READ, SORT, OUTPUT);

        if (config.sortType() == SortType.BY_COUNT) {
            flow.add(TRANSFORM);
        }

        List<Step<T>> pipeline = new ArrayList<>();

        for (StepType type : flow) {
            pipeline.add(createStep(type, config));
        }

        return new Pipeline<>(pipeline);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Comparable<T>> Step<T> createStep(StepType type, Config config) {
        return switch (type) {

            case INPUT -> config.inputFile() != null
                    ? new FileInput<>(config.inputFile())
                    : new ConsoleInput<>();

            case READ -> (Step<T>) switch (config.dataType()) {
                case LONG -> new NumberReader();
                case WORD -> new WordReader();
                case LINE -> new LineReader();
            };

            case TRANSFORM -> new FrequencyTransformer<>();

            case SORT -> switch (config.sortType()) {
                case NATURAL -> new NaturalSorter<>();
                case BY_COUNT -> new ByCountSorter<>();
            };

            case OUTPUT -> config.outputFile() != null
                    ? new FileOutput<>(config.outputFile())
                    : new ConsoleOutput<>();
        };
    }
}
