package dev.accelerated.language.teacher.infrastructure.person;

import dev.accelerated.language.teacher.domain.person.Person;
import dev.accelerated.language.teacher.domain.person.PersonCollectionPort;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Component
public class PersonCollectionJpaAdapter implements PersonCollectionPort {
    PersonRecordRepository repository;

    private PersonRecord fromPerson(Person person) {
        return new PersonRecord(
                person.id(), person.firstName(), person.lastName()
        );
    }

    @Override
    public Person persist(Person person) {
        return repository.save(fromPerson(person)).toPerson();
    }

    @Override
    public Optional<Person> get(UUID personId) {
        return repository
                .findById(personId)
                .map(PersonRecord::toPerson);
    }

    @Override
    public Page<Person> findAll(int page, int size) {
        var pageable = PageRequest.of(page, size);
        return repository
                .findAll(pageable)
                .map(PersonRecord::toPerson);
    }
}
