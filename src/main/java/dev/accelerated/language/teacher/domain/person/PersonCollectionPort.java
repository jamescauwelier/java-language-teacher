package dev.accelerated.language.teacher.domain.person;

import dev.accelerated.language.teacher.domain.id.Id;

import java.util.Optional;

public interface PersonCollectionPort {
    Person add(Person person);

    Optional<Person> findById(Id personId);
}
