package de.eisner.sorting.processing.reader;

import de.eisner.sorting.config.Config;
import de.eisner.sorting.config.DataType;
import de.eisner.sorting.config.SortType;
import de.eisner.sorting.pipeline.Context;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberReaderTest {

    @Test
    void shouldReadValidNumbersAndSkipInvalid() {
        Context<Long> ctx = new Context<>(
                new Config(DataType.LONG, SortType.NATURAL, null, null)
        );
        ctx.setScanner(new Scanner("1 2 abc 3"));

        new NumberReader().execute(ctx);

        assertEquals(3, ctx.getRawInput().size());
        assertTrue(ctx.getRawInput().contains(1L));
        assertTrue(ctx.getRawInput().contains(3L));
    }
}
