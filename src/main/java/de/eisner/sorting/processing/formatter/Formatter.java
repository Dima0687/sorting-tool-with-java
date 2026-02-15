package de.eisner.sorting.processing.formatter;

import de.eisner.sorting.config.Config;
import de.eisner.sorting.config.SortType;
import de.eisner.sorting.pipeline.Context;

/**
 * Utility class responsible for generating the final formatted output string.
 *
 * <p>The formatter builds a header containing the total number of elements
 * and delegates the body formatting to the configured {@link SortType}.
 *
 * <p>This class is not intended to be instantiated.
 */
public final class Formatter {

    /**
     * Formats the processed data into a human-readable output string.
     *
     * @param context the execution context containing input and results
     * @param <T>     the type of processed elements
     * @return the formatted output string
     */
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
