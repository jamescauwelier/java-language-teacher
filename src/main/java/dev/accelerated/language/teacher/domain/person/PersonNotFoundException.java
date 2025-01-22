package dev.accelerated.language.teacher.domain.person;

import java.util.UUID;

public class PersonNotFoundException extends RuntimeException {
    PersonNotFoundException(UUID personId) {
        super(String.format("Person with id '%s' was not found", personId.toString()));
    }
}
