package de.eisner.sorting.processing.reader;

import de.eisner.sorting.pipeline.Context;
import de.eisner.sorting.pipeline.Step;

import java.util.Scanner;

/**
 * Pipeline step that reads whitespace-separated words.
 *
 * <p>Each token is added to the raw input list.
 */
public class WordReader implements Step<String> {

    /**
     * Reads all tokens from the scanner
     * and stores them in the context.
     *
     * @param context the shared execution context
     */
    @Override
    public void execute(Context<String> context) {
        Scanner scanner = context.getScanner();

        while (scanner.hasNext()) {
            context.getRawInput().add(scanner.next());
        }

        scanner.close();
    }
}
