package dev.accelerated.language.teacher.domain.person;

import org.springframework.data.domain.Page;

import java.util.Optional;
import java.util.UUID;

public interface PersonCollectionPort {
    Person persist(Person person);

    Optional<Person> get(UUID personId);

    default Person getRequired(UUID personId) throws PersonNotFoundException {
        return get(personId)
                .orElseThrow(() -> new PersonNotFoundException(personId));
    }

    Page<Person> findAll(int page, int size);
}
