package dev.accelerated.language.teacher.application.person;

import dev.accelerated.language.teacher.application.person.commands.CreatePersonCommand;
import dev.accelerated.language.teacher.application.person.queries.FindAllPersons;
import dev.accelerated.language.teacher.application.person.queries.FindPersonById;
import dev.accelerated.language.teacher.domain.person.Person;
import dev.accelerated.language.teacher.domain.person.PersonCollectionPort;
import dev.accelerated.language.teacher.domain.uuid.UUIDGeneratorPort;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@AllArgsConstructor
public class PersonService {
    private final UUIDGeneratorPort idGenerator;
    private final PersonCollectionPort persons;

    @Transactional
    public Person createPerson(CreatePersonCommand command) {
        Person createdPerson = new Person(idGenerator.generate(), command.firstName(), command.lastName());
        return persons.add(createdPerson);
    }

    public Optional<Person> findById(FindPersonById query) {
        return persons.get(query.personId());
    }

    public Page<Person> findAll(FindAllPersons query) {
        return persons.findAll(query.page(), query.maxCount());
    }

    @Transactional
    public void rename(UUID personId, String firstName, String lastName) {
        persons
                .get(personId)
                .map((p) -> {
                    p.rename(firstName, lastName);
                    return p;
                });
    }
}
