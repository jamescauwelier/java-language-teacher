package dev.accelerated.language.teacher.application.person;

import dev.accelerated.language.teacher.application.person.commands.CreatePersonCommand;
import dev.accelerated.language.teacher.application.person.queries.FindPersonById;
import dev.accelerated.language.teacher.domain.id.IdGeneratorPort;
import dev.accelerated.language.teacher.domain.person.Person;
import dev.accelerated.language.teacher.domain.person.PersonCollectionPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class PersonService {
    private final IdGeneratorPort idGenerator;
    private final PersonCollectionPort persons;

    public Person createPerson(CreatePersonCommand command) {
        Person createdPerson = new Person(idGenerator.generate(), command.firstName(), command.lastName());
        return persons.add(createdPerson);
    }

    public Optional<Person> findById(FindPersonById query) {
        return persons.findById(query.personId());
    }
}
