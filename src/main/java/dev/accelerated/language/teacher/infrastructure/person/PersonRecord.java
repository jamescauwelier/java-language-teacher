package dev.accelerated.language.teacher.infrastructure.person;

import dev.accelerated.language.teacher.domain.person.Person;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PersonRecord {
    @Id
    UUID id;
    String firstName;
    String lastName;

    Person toPerson() {
        return new Person(
                id, firstName, lastName
        );
    }
}
