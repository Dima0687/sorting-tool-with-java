package de.eisner.sorting.processing.reader;

import de.eisner.sorting.pipeline.Context;
import de.eisner.sorting.pipeline.Step;

import java.util.Scanner;

public class LineReader implements Step<String> {
    @Override
    public void execute(Context<String> context) {
        Scanner scanner = context.getScanner();

        while (scanner.hasNextLine()) {
            context.getRawInput().add(scanner.nextLine());
        }

        scanner.close();
    }
}
