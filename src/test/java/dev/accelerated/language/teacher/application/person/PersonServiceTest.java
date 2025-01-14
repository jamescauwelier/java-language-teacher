package dev.accelerated.language.teacher.application.person;

import dev.accelerated.language.teacher.TestConfig;
import dev.accelerated.language.teacher.application.person.commands.CreatePersonCommand;
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
}
