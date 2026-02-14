package de.eisner.sorting.pipeline;

import de.eisner.sorting.config.Config;
import de.eisner.sorting.model.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Context<T extends Comparable<T>> {
    private final Config config;
    private final List<T> rawInput = new ArrayList<>();
    private final List<Result<T>> results = new ArrayList<>();

    private Scanner scanner;

    public Context(Config config) {
        this.config = config;
    }

    public Config getConfig() {
        return config;
    }

    public List<T> getRawInput() {
        return rawInput;
    }

    public List<Result<T>> getResults() {
        return results;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}
