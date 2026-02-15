package de.eisner.sorting.processing.formatter;

import de.eisner.sorting.config.Config;
import de.eisner.sorting.config.DataType;
import de.eisner.sorting.config.SortType;
import de.eisner.sorting.pipeline.Context;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FormatterTest {

    @Test
    void shouldFormatOutput() {
        Config config = new Config(DataType.WORD, SortType.NATURAL, null, null);
        Context<String> ctx = new Context<>(config);

        ctx.getRawInput().add("hello");

        String result = Formatter.format(ctx);

        assertTrue(result.contains("Total words: 1."));
    }
}
