package de.eisner.sorting.processing.reader;

import de.eisner.sorting.pipeline.Context;
import de.eisner.sorting.pipeline.Step;

import java.util.Scanner;

/**
 * Pipeline step that reads full lines from the assigned scanner.
 *
 * <p>Each line is added as a single element to the raw input list.
 */
public class LineReader implements Step<String> {

    /**
     * Reads all available lines from the scanner
     * and stores them in the context.
     *
     * @param context the shared execution context
     */
    @Override
    public void execute(Context<String> context) {
        Scanner scanner = context.getScanner();

        while (scanner.hasNextLine()) {
            context.getRawInput().add(scanner.nextLine());
        }

        scanner.close();
    }
}
