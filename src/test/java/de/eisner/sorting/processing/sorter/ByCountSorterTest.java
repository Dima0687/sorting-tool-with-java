package de.eisner.sorting.processing.sorter;

import de.eisner.sorting.model.Result;
import de.eisner.sorting.pipeline.Context;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ByCountSorterTest {

    @Test
    void shouldSortByFrequency() {
        Context<String> ctx = new Context<>(null);

        ctx.getResults().add(new Result<>("words", 3, true, "a", 2, 66));
        ctx.getResults().add(new Result<>("words", 3, true, "b", 1, 33));

        new ByCountSorter<String>().execute(ctx);

        assertEquals("b", ctx.getResults().getFirst().dataEntry());
    }
}
