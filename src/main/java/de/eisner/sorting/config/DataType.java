package de.eisner.sorting.config;

/**
 * Represents the supported types of input data that can be processed.
 *
 * <p>Each data type defines a human-readable label used for reporting purposes.
 */
public enum DataType {
    /**
     * Represents numeric input values of type {@code long}.
     */
    LONG("numbers"),

    /**
     * Represents individual words separated by whitespace.
     */
    WORD("words"),

    /**
     * Represents entire lines of text.
     */
    LINE("lines");

    private final String label;

    DataType(String label) {
        this.label = label;
    }

    /**
     * Returns the human-readable label of the data type.
     *
     * @return the label associated with this data type
     */
    public String label() {
        return label;
    }

    /**
     * Converts a string value into a corresponding {@code DataType}.
     * The conversion is case-insensitive.
     *
     * @param value the string representation of the data type
     * @return the matching {@code DataType}
     * @throws IllegalArgumentException if the value does not match any constant
     */
    public static DataType from(String value) {
        return valueOf(value.toUpperCase());
    }
}
