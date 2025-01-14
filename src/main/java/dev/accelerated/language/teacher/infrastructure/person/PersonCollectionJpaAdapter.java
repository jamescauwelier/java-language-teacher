package dev.accelerated.language.teacher.infrastructure.person;

import dev.accelerated.language.teacher.domain.id.Id;
import dev.accelerated.language.teacher.domain.person.Person;
import dev.accelerated.language.teacher.domain.person.PersonCollectionPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@AllArgsConstructor
@Component
public class PersonCollectionJpaAdapter implements PersonCollectionPort {
    PersonRecordRepository repository;

    @Override
    public Person add(Person person) {
        return repository
                .save(PersonRecord.fromPerson(person))
                .toPerson();
    }

    @Override
    public Optional<Person> findById(Id personId) {
        return repository.findById(personId.toString())
                .map(PersonRecord::toPerson);
    }
}
