package dev.accelerated.language.teacher.application.person;

import dev.accelerated.language.teacher.TestConfig;
import dev.accelerated.language.teacher.application.person.commands.CreatePersonCommand;
import dev.accelerated.language.teacher.application.person.queries.FindAllPersons;
import dev.accelerated.language.teacher.application.person.queries.FindPersonById;
import dev.accelerated.language.teacher.domain.person.Person;
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
    void aPersonCanBeCreated() {
        CreatePersonCommand command = new CreatePersonCommand("Sylvester", "Stallone");
        Person newPerson = personService.createPerson(command);
        assert (newPerson != null);
    }

    @Test
    void aCreatedPersonCanBeFound() {
        CreatePersonCommand command = new CreatePersonCommand("Sylvester", "Stallone");
        Person newPerson = personService.createPerson(command);


        FindPersonById query = new FindPersonById(newPerson.getId());
        Person foundPerson = personService.findById(query).get();
        assertEquals(newPerson, foundPerson);
    }

    @Test
    void allPersonsCanBeFound() {
        for (int i = 1; i <= 10; i++) {
            personService.createPerson(new CreatePersonCommand("John " + i, "Wick " + i));
        }

        var query = new FindAllPersons(1, 6);
        var persons = personService.findAll(query);
        assertEquals(10, persons.getTotalElements());
        assertEquals(2, persons.getTotalPages());
        assertEquals(4, persons.getNumberOfElements());
        var person = persons.getContent().get(0);
        assertEquals("John 7", person.getFirstName());
    }

    @Test
    void aCreatedPersonCanBeRenamed() {
        // this test is only made to verify @Transactional feature properties
        CreatePersonCommand command = new CreatePersonCommand("Sylvester", "Stallone");
        Person newPerson = personService.createPerson(command);

        personService.rename(newPerson.getId(), "Joske", "Vermeulen");

        FindPersonById query = new FindPersonById(newPerson.getId());
        Person foundPerson = personService.findById(query).get();

        assertEquals("Joske", foundPerson.getFirstName());
    }
}
