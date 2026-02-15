package de.eisner.sorting.processing.sorter;

import de.eisner.sorting.pipeline.Context;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NaturalSorterTest {

    @Test
    void shouldSortNaturally() {
        Context<String> ctx = new Context<>(null);
        ctx.getRawInput().add("b");
        ctx.getRawInput().add("a");

        new NaturalSorter<String>().execute(ctx);

        assertEquals("a", ctx.getRawInput().getFirst());
    }
}
