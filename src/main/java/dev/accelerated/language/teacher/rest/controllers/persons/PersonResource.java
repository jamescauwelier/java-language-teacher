package dev.accelerated.language.teacher.rest.controllers.persons;

import dev.accelerated.language.teacher.domain.person.Person;

public record PersonResource(
        String id,
        String firstName,
        String lastName
) {
    static PersonResource fromPerson(Person person) {
        return new PersonResource(
                person.id().toString(),
                person.firstName(),
                person.lastName()
        );
    }
}
