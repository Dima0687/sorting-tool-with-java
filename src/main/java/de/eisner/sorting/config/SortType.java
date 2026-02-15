package de.eisner.sorting.config;

import de.eisner.sorting.pipeline.Context;

/**
 * Defines the available sorting strategies.
 *
 * <p>Each sort type provides a specific output formatting implementation
 * based on the processed {@link de.eisner.sorting.pipeline.Context}.
 */
public enum SortType {

    /**
     * Sorts data in its natural order and outputs all elements in sequence.
     */
    NATURAL {

        /**
         * Formats the sorted data in natural order.
         *
         * @param ctx the pipeline context containing raw and processed data
         * @param <T> the type of elements being sorted
         * @return a formatted string containing the sorted elements
         */
        @Override
        public <T extends Comparable<T>> String format(Context<T> ctx) {
            StringBuilder sb = new StringBuilder("Sorted data:");
            ctx.getRawInput().forEach(item -> sb.append(" ").append(item));
            return sb.toString();
        }
    },

    /**
     * Sorts data by frequency in ascending order and outputs
     * occurrence count and percentage for each entry.
     */
    BY_COUNT {

        /**
         * Formats the sorted data by frequency.
         *
         * @param ctx the pipeline context containing aggregated results
         * @param <T> the type of elements being sorted
         * @return a formatted string containing frequency statistics
         */
        @Override
        public <T extends Comparable<T>> String format(Context<T> ctx) {
            StringBuilder sb = new StringBuilder();
            ctx.getResults().forEach(r ->
                    sb.append(String.format("%s: %d time(s), %d%%%n",
                            r.dataEntry(), r.frequency(), r.percentage()))
            );
            return sb.toString().trim();
        }
    };

    /**
     * Converts a string value into a corresponding {@code SortType}.
     * Supports both camelCase and snake_case input formats.
     *
     * @param value the string representation of the sorting type
     * @return the matching {@code SortType}
     * @throws IllegalArgumentException if the value does not match any constant
     */
    public static SortType from(String value) {
        return valueOf(value
                    .replaceAll("([a-z])([A-Z])", "$1_$2")
                    .toUpperCase());
    }

    /**
     * Formats the processed data according to the selected sorting strategy.
     *
     * @param ctx the pipeline context containing processing results
     * @param <T> the type of elements being processed
     * @return a formatted output string
     */
    public abstract <T extends Comparable<T>> String format(Context<T> ctx);
}
