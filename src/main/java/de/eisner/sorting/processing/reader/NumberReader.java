package de.eisner.sorting.processing.reader;

import de.eisner.sorting.pipeline.Context;
import de.eisner.sorting.pipeline.Step;

import java.util.Scanner;

public class NumberReader implements Step<Long> {

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
