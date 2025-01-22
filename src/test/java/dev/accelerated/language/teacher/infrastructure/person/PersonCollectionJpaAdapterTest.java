package dev.accelerated.language.teacher.infrastructure.person;

import dev.accelerated.language.teacher.domain.person.Person;
import dev.accelerated.language.teacher.domain.uuid.UUIDGeneratorPort;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PersonCollectionJpaAdapterTest {
    @Autowired
    UUIDGeneratorPort uuid;

    @Autowired
    PersonCollectionJpaAdapter collection;

    @Test
    @Transactional
    void aPersonCanBeAddedToACollection() {
        UUID id = uuid.generate();
        String firstName = "John";
        String lastName = "Bon Jovi";
        var person = collection.add(new Person(id, firstName, lastName));

        assertEquals(id, person.id());
        assertEquals(firstName, person.firstName());
        assertEquals(lastName, person.lastName());
    }

    @Test
    @Transactional
    void aNonExistingPersonCannotBeFound() {
        UUID id = uuid.generate();
        assertEquals(Optional.empty(), collection.get(id));
    }

    @Test
    @Transactional
    void aPersonCanBeFoundAfterAdding() {
        UUID id = uuid.generate();
        String firstName = "John";
        String lastName = "Bon Jovi";
        collection.add(new Person(id, firstName, lastName));
        var person = collection.get(id).get();

        assertEquals(id, person.id());
        assertEquals(firstName, person.firstName());
        assertEquals(lastName, person.lastName());
    }

    @Test
    @Transactional
    void anEmptyPageOfPersonsCanBeFound() {
        var page = collection.findAll(0, 10);
        assertEquals(0, page.getTotalElements());
    }

    @Test
    @Transactional
    void aNonEmptyPageOfPersonsCanBeFound() {
        for (int i = 1; i <= 10; i++) {
            collection.add(new Person(uuid.generate(), "John " + i, "Wick " + i));
        }
        var page = collection.findAll(0, 2);
        assertEquals(10, page.getTotalElements());
        assertEquals(5, page.getTotalPages());
        assertEquals(2, page.getNumberOfElements());

        page = collection.findAll(1, 2);
        var person = page.stream().findFirst().get();
        assertEquals("John 3", person.firstName());
        assertEquals("Wick 3", person.lastName());
    }
}
