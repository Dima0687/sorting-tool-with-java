package de.eisner.sorting.processing.reader;

import de.eisner.sorting.pipeline.Context;
import de.eisner.sorting.pipeline.Step;

import java.util.Scanner;

public class WordReader implements Step<String> {

    @Override
    public void execute(Context<String> context) {
        Scanner scanner = context.getScanner();

        while (scanner.hasNext()) {
            context.getRawInput().add(scanner.next());
        }

        scanner.close();
    }
}
