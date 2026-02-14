package de.eisner.sorting.model;

public record Result<T extends Comparable<T>>(
        String type,
        int total,
        boolean isByCount,
        T dataEntry,
        long frequency,
        long percentage
) implements Comparable<Result<T>> {
    @Override
    public int compareTo(Result<T> o) {
        int res = Long.compare(this.frequency, o.frequency);
        if (res != 0) {
            return res;
        }
        return this.dataEntry.compareTo(o.dataEntry);
    }
}
