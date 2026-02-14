package de.eisner.sorting.config;

public enum DataType {
    LONG("numbers"),
    WORD("words"),
    LINE("lines");

    private final String label;

    DataType(String label) {
        this.label = label;
    }

    public String label() {
        return label;
    }

    public static DataType from(String value) {
        return valueOf(value.toUpperCase());
    }
}
