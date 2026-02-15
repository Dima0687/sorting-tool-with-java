package de.eisner.sorting.processing.transform;

import de.eisner.sorting.config.Config;
import de.eisner.sorting.config.DataType;
import de.eisner.sorting.config.SortType;
import de.eisner.sorting.pipeline.Context;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FrequencyTransformerTest {

    @Test
    void shouldCalculateFrequency() {
        Config config = new Config(DataType.WORD, SortType.BY_COUNT, null, null);
        Context<String> ctx = new Context<>(config);

        ctx.getRawInput().add("a");
        ctx.getRawInput().add("a");
        ctx.getRawInput().add("b");

        new FrequencyTransformer<String>().execute(ctx);

        assertEquals(2, ctx.getResults().size());
        assertEquals(2, ctx.getResults().getFirst().frequency());
    }
}
