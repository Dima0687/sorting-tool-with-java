package de.eisner.sorting.processing.reader;

import de.eisner.sorting.pipeline.Context;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordReaderTest {

    @Test
    void shouldReadWords() {
        Context<String> ctx = new Context<>(null);
        ctx.setScanner(new Scanner("hello world"));

        new WordReader().execute(ctx);

        assertEquals(2, ctx.getRawInput().size());
    }
}
