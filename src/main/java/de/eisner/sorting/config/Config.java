package de.eisner.sorting.config;

/**
 * Immutable configuration record that holds all runtime settings
 * required to execute the sorting pipeline.
 *
 * @param dataType   the type of input data to be processed
 * @param sortType   the sorting strategy to apply
 * @param inputFile  optional path to the input file; {@code null} if console input is used
 * @param outputFile optional path to the output file; {@code null} if console output is used
 */
public record Config(
        DataType dataType,
        SortType sortType,
        String inputFile,
        String outputFile
) {
}
