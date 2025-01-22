package dev.accelerated.language.teacher.domain.uuid;

import org.junit.jupiter.api.Test;

import java.util.UUID;

public class RandomUuidGeneratorAdapterTest {
    @Test
    void aRandomIdCanBeGenerated() {
        UUIDGeneratorPort generator = new RandomUUIDGeneratorAdapter();
        UUID id = generator.generate();
    }
}
