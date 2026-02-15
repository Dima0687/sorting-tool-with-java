package de.eisner.sorting.config;

import de.eisner.sorting.pipeline.Context;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SortTypeTest {

    @Test
    void shouldConvertCamelCase() {
        assertEquals(SortType.BY_COUNT, SortType.from("byCount"));
        assertEquals(SortType.NATURAL, SortType.from("natural"));
    }

    @Test
    void naturalFormatShouldReturnSortedDataString() {
        Config config = new Config(DataType.WORD, SortType.NATURAL, null, null);
        Context<String> ctx = new Context<>(config);
        ctx.getRawInput().add("b");
        ctx.getRawInput().add("a");

        String result = SortType.NATURAL.format(ctx);

        assertTrue(result.contains("Sorted data:"));
    }
}
