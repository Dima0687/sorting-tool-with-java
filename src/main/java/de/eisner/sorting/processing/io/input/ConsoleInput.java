package de.eisner.sorting.processing.io.input;

import de.eisner.sorting.pipeline.Context;
import de.eisner.sorting.pipeline.Step;

import java.util.Scanner;

public class ConsoleInput<T extends Comparable<T>> implements Step<T> {
    @Override
    public void execute(Context<T> context) {
        Scanner scanner = new Scanner(System.in);
        context.setScanner(scanner);
    }
}
