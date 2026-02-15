package de.eisner.sorting.processing.reader;

import de.eisner.sorting.pipeline.Context;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LineReaderTest {

    @Test
    void shouldReadLines() {
        Context<String> ctx = new Context<>(null);
        ctx.setScanner(new Scanner("line1\nline2"));

        new LineReader().execute(ctx);

        assertEquals(2, ctx.getRawInput().size());
    }
}
