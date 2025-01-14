package dev.accelerated.language.teacher.infrastructure.person;

import dev.accelerated.language.teacher.domain.id.Id;
import dev.accelerated.language.teacher.domain.person.Person;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
class PersonRecord {
    @jakarta.persistence.Id
    String personId;
    String firstName;
    String lastName;

    static PersonRecord fromPerson(Person person) {
        return new PersonRecord(
                person.getId().toString(),
                person.getFirstName(),
                person.getLastName()
        );
    }

    Person toPerson() {
        return new Person(Id.fromString(personId), firstName, lastName);
    }
}
