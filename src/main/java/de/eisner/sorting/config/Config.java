package de.eisner.sorting.config;

public record Config(
        DataType dataType,
        SortType sortType,
        String inputFile,
        String outputFile
) {
}
