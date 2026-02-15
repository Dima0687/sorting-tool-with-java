package de.eisner.sorting.pipeline;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PipelineTest {

    @Test
    void shouldExecuteAllSteps() {
        Step<String> step = context -> context.getRawInput().add("test");

        Pipeline<String> pipeline = new Pipeline<>(List.of(step));

        Context<String> ctx = new Context<>(null);
        pipeline.run(ctx);

        assertEquals(1, ctx.getRawInput().size());
    }
}
