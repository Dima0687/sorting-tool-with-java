package de.eisner.sorting.pipeline;

import de.eisner.sorting.config.Config;
import de.eisner.sorting.config.DataType;
import de.eisner.sorting.config.SortType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContextTest {

    @Test
    void shouldStoreConfig() {
        Config config = new Config(DataType.WORD, SortType.NATURAL, null, null);
        Context<String> ctx = new Context<>(config);

        assertEquals(config, ctx.getConfig());
    }
}
