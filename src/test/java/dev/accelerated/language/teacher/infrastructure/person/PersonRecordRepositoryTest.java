package dev.accelerated.language.teacher.infrastructure.person;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PersonRecordRepositoryTest {

    @Autowired
    PersonRecordRepository repository;

    @Test
    void contextLoads() {
    }

    @Test
    void canSaveAUserRecord() {
        PersonRecord person = new PersonRecord("abc", "John", "Wick");
        PersonRecord savedPerson = repository.save(person);

        PersonRecord foundById = repository.findById("abc").get();

        assertEquals("abc", foundById.personId);
        assertEquals("John", foundById.firstName);
        assertEquals("Wick", foundById.lastName);
    }
}
