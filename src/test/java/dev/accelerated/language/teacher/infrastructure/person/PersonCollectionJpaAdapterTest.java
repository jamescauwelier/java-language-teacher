package dev.accelerated.language.teacher.infrastructure.person;

import dev.accelerated.language.teacher.domain.person.Person;
import dev.accelerated.language.teacher.domain.uuid.UUIDGeneratorPort;
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
    void aPersonCanBeAddedToACollection() {
        UUID id = uuid.generate();
        String firstName = "John";
        String lastName = "Bon Jovi";
        var person = collection.add(new Person(id, firstName, lastName));

        assertEquals(id, person.getId());
        assertEquals(firstName, person.getFirstName());
        assertEquals(lastName, person.getLastName());
    }

    @Test
    void aNonExistingPersonCannotBeFound() {
        UUID id = uuid.generate();
        assertEquals(Optional.empty(), collection.get(id));
    }

    @Test
    void aPersonCanBeFoundAfterAdding() {
        UUID id = uuid.generate();
        String firstName = "John";
        String lastName = "Bon Jovi";
        collection.add(new Person(id, firstName, lastName));
        var person = collection.get(id).get();

        assertEquals(id, person.getId());
        assertEquals(firstName, person.getFirstName());
        assertEquals(lastName, person.getLastName());
    }
}
