package dev.accelerated.language.teacher.domain.id;

import net.jqwik.api.Example;
import net.jqwik.api.Group;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Group
public class IdTest {
    @Example
    void anIdCanBeConstructed() {
        Id id = new Id(UUID.fromString("1946191-8adb-7a89-9fa6-65316ca35dab"));
        assertEquals("01946191-8adb-7a89-9fa6-65316ca35dab", id.toString());
    }

    @Example
    void anIdCanBeCompared() {
        Id first = new Id(UUID.fromString("1946191-8adb-7a89-9fa6-65316ca35dab"));
        Id second = new Id(UUID.fromString("1946191-8adb-7a89-9fa6-65316ca35dab"));
        assertEquals(first, second);
    }

    @Example
    void onlyUuidV7IsValidAsId() {
        assertThrows(InvalidIdException.class, () -> {
            UUID uuid = UUID.fromString("0f45478e-f8a6-4e07-9084-e9630ebc73a7");
            Id id = new Id(uuid);
        });
    }
}
