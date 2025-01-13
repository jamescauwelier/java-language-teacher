package dev.accelerated.language.teacher.domain.id;

import net.jqwik.api.Example;
import net.jqwik.api.Group;

@Group
public class RandomIdGeneratorAdapterTest {
    @Example
    void aRandomIdCanBeGenerated() {
        IdGeneratorPort generator = new RandomIdGeneratorAdapter();
        Id id = generator.generate();
    }
}
