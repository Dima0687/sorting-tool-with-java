package de.eisner.sorting.processing.reader;

import de.eisner.sorting.pipeline.Context;
import de.eisner.sorting.pipeline.Step;

import java.util.Scanner;

/**
 * Pipeline step that reads numeric values of type {@code long}.
 *
 * <p>Non-numeric tokens are skipped with a console warning.
 */
public class NumberReader implements Step<Long> {

    /**
     * Reads and parses numeric input values from the scanner.
     *
     * @param ctx the shared execution context
     */
    @Override
    public void execute(Context<Long> ctx) {
        Scanner scanner = ctx.getScanner();

        while (scanner.hasNext()) {
            String token = scanner.next();

            try {
                long value = Long.parseLong(token);
                ctx.getRawInput().add(value);
            } catch (NumberFormatException e) {
                System.out.printf("\"%s\" is not long. It will be skipped%n", token);
            }
        }

        scanner.close();
    }
}
