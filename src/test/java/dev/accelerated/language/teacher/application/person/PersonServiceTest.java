package dev.accelerated.language.teacher.application.person;

import dev.accelerated.language.teacher.TestConfig;
import dev.accelerated.language.teacher.application.person.commands.RegisterPersonCommand;
import dev.accelerated.language.teacher.application.person.queries.FindAllPersons;
import dev.accelerated.language.teacher.application.person.queries.FindPersonById;
import dev.accelerated.language.teacher.domain.person.Person;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Import(TestConfig.class)
public class PersonServiceTest {
    @Autowired
    private PersonService personService;

    @Test
    void contextLoads() {
    }

    @Test
    @Transactional
    void aPersonCanBeCreated() {
        RegisterPersonCommand command = new RegisterPersonCommand("Sylvester", "Stallone");
        Person newPerson = personService.registerPerson(command);
        assert (newPerson != null);
    }

    @Test
    @Transactional
    void aCreatedPersonCanBeFound() {
        RegisterPersonCommand command = new RegisterPersonCommand("Sylvester", "Stallone");
        Person newPerson = personService.registerPerson(command);


        FindPersonById query = new FindPersonById(newPerson.id());
        Person foundPerson = personService.findById(query).get();
        assertEquals(newPerson, foundPerson);
    }

    @Test
    @Transactional
    void allPersonsCanBeFound() {
        for (var i = 1; i <= 10; i++) {
            personService.registerPerson(new RegisterPersonCommand("John " + i, "Wick" + i));
        }

        var query = new FindAllPersons(1, 6);
        var persons = personService.findAll(query);
        assertEquals(10, persons.getTotalElements());
        assertEquals(2, persons.getTotalPages());
        assertEquals(4, persons.getNumberOfElements());
        var person = persons.getContent().get(0);
        assertEquals("John 7", person.firstName());
    }

    @Test
    @Transactional
    void aCreatedPersonCanBeRenamed() {
        // this test is only made to verify @Transactional feature properties
        RegisterPersonCommand command = new RegisterPersonCommand("Sylvester", "Stallone");
        Person newPerson = personService.registerPerson(command);

        personService.rename(newPerson.id(), "Joske", "Vermeulen");

        FindPersonById query = new FindPersonById(newPerson.id());
        Person foundPerson = personService.findById(query).get();

        assertEquals("Joske", foundPerson.firstName());
    }
}
