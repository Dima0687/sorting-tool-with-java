package de.eisner.sorting.processing.formatter;

import de.eisner.sorting.config.Config;
import de.eisner.sorting.pipeline.Context;

public final class Formatter {

    public static <T extends Comparable<T>> String format(Context<T> context) {

        Config config = context.getConfig();
        int totalCount = context.getRawInput().size();
        String typeLabel = config.dataType().label();

        String header = String.format("Total %s: %d.%n",
                typeLabel, totalCount);

        String body = config.sortType().format(context);

        return header + body;
    }
}
