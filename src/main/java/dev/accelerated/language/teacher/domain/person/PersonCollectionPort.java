package dev.accelerated.language.teacher.domain.person;

import java.util.Optional;
import java.util.UUID;

public interface PersonCollectionPort {
    Person add(Person person);

    Optional<Person> get(UUID personId);
}
