package de.eisner.sorting.processing.transform;

import de.eisner.sorting.config.Config;
import de.eisner.sorting.config.SortType;
import de.eisner.sorting.model.Result;
import de.eisner.sorting.pipeline.Context;
import de.eisner.sorting.pipeline.Step;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * Pipeline step that aggregates raw input data
 * into frequency-based result entries.
 *
 * <p>For each distinct element, a {@link Result}
 * object is created containing occurrence count and percentage share.
 *
 * @param <T> the type of elements being processed
 */
public class FrequencyTransformer<T extends Comparable<T>> implements Step<T> {
    /**
     * Groups raw input elements by frequency and
     * populates the result list inside the context.
     *
     * @param context the shared execution context
     */
    @Override
    public void execute(Context<T> context) {
        Map<T, Long> frequency =
                context.getRawInput()
                        .stream()
                        .collect(Collectors.groupingBy(
                                t -> t,
                                Collectors.counting()
                        ));

        Config config = context.getConfig();

        String type = config.dataType().label();
        int total = context.getRawInput().size();

        frequency
                .forEach((dataEntry, freq) -> context
                        .getResults()
                        .add(new Result<>(
                                type,
                                total,
                                config.sortType() == SortType.BY_COUNT,
                                dataEntry,
                                freq,
                                Math.round(100.0 * freq / total)
                                )));
    }
}
