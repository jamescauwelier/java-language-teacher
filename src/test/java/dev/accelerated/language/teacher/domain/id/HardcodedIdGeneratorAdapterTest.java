package dev.accelerated.language.teacher.domain.id;

import net.jqwik.api.Example;
import net.jqwik.api.Group;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Group
public class HardcodedIdGeneratorAdapterTest {
    @Example
    void aHardcodedIdCanBeGeneratedOnce() {
        IdGeneratorPort generator = new HardcodedIdGeneratorAdapter();
        assertEquals(new Id(UUID.fromString("01946191-8adb-7997-85d9-6d9279bd0d89")), generator.generate());
    }

    @Example
    void aHardcodedIdCanBeGeneratedTwice() {
        IdGeneratorPort generator = new HardcodedIdGeneratorAdapter();
        assertEquals(new Id(UUID.fromString("01946191-8adb-7997-85d9-6d9279bd0d89")), generator.generate());
        assertEquals(new Id(UUID.fromString("1946191-8adb-73f1-9b21-662e38ccc151")), generator.generate());
    }
}
