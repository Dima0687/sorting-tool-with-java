package de.eisner.sorting.config;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArgumentParserTest {

    @Test
    void shouldParseValidArguments() {
        String[] args = {
          "-dataType", "long",
          "-sortingType", "byCount",
          "-inputFile", "input.txt",
          "-outputFile", "output.txt"
        };

        Optional<Config> result = ArgumentParser.parse(args);

        assertTrue(result.isPresent());

        Config config = result.get();
        assertEquals(DataType.LONG, config.dataType());
        assertEquals(SortType.BY_COUNT, config.sortType());
        assertEquals("input.txt", config.inputFile());
        assertEquals("output.txt", config.outputFile());
    }

    @Test
    void shouldUseDefaultsWhenMissing() {
        String[] args = {};
        Optional<Config> result = ArgumentParser.parse(args);

        assertTrue(result.isPresent());

        Config config = result.get();
        assertEquals(DataType.WORD, config.dataType());
        assertEquals(SortType.NATURAL, config.sortType());
    }

    @Test
    void shouldReturnEmptyOnInvalidDataType() {
        String[] args = {"-dataType", "invalid"};

        Optional<Config> result = ArgumentParser.parse(args);

        assertTrue(result.isEmpty());
    }
}
