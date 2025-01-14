package dev.accelerated.language.teacher.domain.person;

import org.springframework.data.domain.Page;

import java.util.Optional;
import java.util.UUID;

public interface PersonCollectionPort {
    Person add(Person person);

    Optional<Person> get(UUID personId);

    Page<Person> findAll(int page, int size);
}
