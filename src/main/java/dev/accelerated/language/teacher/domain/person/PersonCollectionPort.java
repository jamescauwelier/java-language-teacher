package dev.accelerated.language.teacher.domain.person;

import java.util.Optional;

public interface PersonCollectionPort {
    Person add(Person person);

    Optional<Person> get(String personId);
}
