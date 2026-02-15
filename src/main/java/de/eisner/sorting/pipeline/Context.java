package de.eisner.sorting.pipeline;

import de.eisner.sorting.config.Config;
import de.eisner.sorting.model.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Represents the shared execution context of the processing pipeline.
 *
 * <p>The context acts as a central data holder that is passed between
 * pipeline steps. It contains the runtime {@link de.eisner.sorting.config.Config},
 * the raw input data, intermediate aggregation results, and the active {@link java.util.Scanner}.
 *
 * @param <T> the type of elements being processed
 */
public class Context<T extends Comparable<T>> {
    private final Config config;
    private final List<T> rawInput = new ArrayList<>();
    private final List<Result<T>> results = new ArrayList<>();

    private Scanner scanner;

    /**
     * Creates a new context instance bound to the given configuration.
     *
     * @param config the application configuration
     */
    public Context(Config config) {
        this.config = config;
    }

    /**
     * Returns the active configuration.
     *
     * @return {@link de.eisner.sorting.config.Config} the configuration used for this execution
     */
    public Config getConfig() {
        return config;
    }

    /**
     * Returns the mutable list containing the raw input data.
     *
     * @return the list of input elements
     */
    public List<T> getRawInput() {
        return rawInput;
    }

    /**
     * Returns the list containing aggregated results
     * used for frequency-based sorting.
     *
     * @return the list of result entries
     */
    public List<Result<T>> getResults() {
        return results;
    }

    /**
     * Returns the currently assigned scanner.
     *
     * @return the scanner instance
     */
    public Scanner getScanner() {
        return scanner;
    }

    /**
     * Sets the scanner to be used by subsequent processing steps.
     *
     * @param scanner the scanner instance
     */
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}
