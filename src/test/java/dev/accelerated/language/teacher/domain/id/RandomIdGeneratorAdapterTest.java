package dev.accelerated.language.teacher.domain.id;

import org.junit.jupiter.api.Test;

public class RandomIdGeneratorAdapterTest {
    @Test
    void aRandomIdCanBeGenerated() {
        IdGeneratorPort generator = new RandomIdGeneratorAdapter();
        Id id = generator.generate();
    }
}
