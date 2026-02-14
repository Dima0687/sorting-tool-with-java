package de.eisner.sorting.config;

import de.eisner.sorting.pipeline.Context;

public enum SortType {
    NATURAL {
        @Override
        public <T extends Comparable<T>> String format(Context<T> ctx) {
            StringBuilder sb = new StringBuilder("Sorted data:");
            ctx.getRawInput().forEach(item -> sb.append(" ").append(item));
            return sb.toString();
        }
    },
    BY_COUNT {
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

    public static SortType from(String value) {
        return valueOf(value
                    .replaceAll("([a-z])([A-Z])", "$1_$2")
                    .toUpperCase());
    }

    public abstract <T extends Comparable<T>> String format(Context<T> ctx);
}
