package dev.accelerated.language.teacher.domain.id;

import dev.accelerated.language.teacher.domain.uuid.HardcodedUUIDGeneratorAdapter;
import dev.accelerated.language.teacher.domain.uuid.UUIDGeneratorPort;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HardcodedIdGeneratorAdapterTest {
    @Test
    void aHardcodedIdCanBeGeneratedOnce() {
        UUIDGeneratorPort generator = new HardcodedUUIDGeneratorAdapter();
        assertEquals(UUID.fromString("01946191-8adb-7997-85d9-6d9279bd0d89"), generator.generate());
    }

    @Test
    void aHardcodedIdCanBeGeneratedTwice() {
        UUIDGeneratorPort generator = new HardcodedUUIDGeneratorAdapter();
        assertEquals(UUID.fromString("01946191-8adb-7997-85d9-6d9279bd0d89"), generator.generate());
        assertEquals(UUID.fromString("1946191-8adb-73f1-9b21-662e38ccc151"), generator.generate());
    }
}
