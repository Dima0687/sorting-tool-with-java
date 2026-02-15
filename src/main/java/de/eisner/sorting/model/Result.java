package de.eisner.sorting.model;

/**
 * Represents a single aggregated result entry produced during
 * frequency-based sorting.
 *
 * <p>This record is immutable and comparable.
 * Results are primarily ordered by ascending frequency,
 * and secondarily by the natural order of the data entry.
 *
 * @param <T>         the type of the data entry
 * @param type        a descriptive label of the data type
 * @param total       total number of processed elements
 * @param isByCount   indicates whether the result was produced using frequency sorting
 * @param dataEntry   the actual data value
 * @param frequency   number of occurrences of the data entry
 * @param percentage  percentage share of the data entry within the total dataset
 */
public record Result<T extends Comparable<T>>(
        String type,
        int total,
        boolean isByCount,
        T dataEntry,
        long frequency,
        long percentage
) implements Comparable<Result<T>> {

    /**
     * Compares this result with another result.
     *
     * <p>Comparison is based first on frequency (ascending),
     * and then on the natural order of the data entry.
     *
     * @param o the other result to compare to
     * @return a negative integer, zero, or a positive integer
     *         as this object is less than, equal to, or greater than the specified object
     */
    @Override
    public int compareTo(Result<T> o) {
        int res = Long.compare(this.frequency, o.frequency);
        if (res != 0) {
            return res;
        }
        return this.dataEntry.compareTo(o.dataEntry);
    }
}
