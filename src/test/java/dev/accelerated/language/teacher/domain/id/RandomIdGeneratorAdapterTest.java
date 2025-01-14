package dev.accelerated.language.teacher.domain.id;

import dev.accelerated.language.teacher.domain.uuid.RandomUUIDGeneratorAdapter;
import dev.accelerated.language.teacher.domain.uuid.UUIDGeneratorPort;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class RandomIdGeneratorAdapterTest {
    @Test
    void aRandomIdCanBeGenerated() {
        UUIDGeneratorPort generator = new RandomUUIDGeneratorAdapter();
        UUID id = generator.generate();
    }
}
