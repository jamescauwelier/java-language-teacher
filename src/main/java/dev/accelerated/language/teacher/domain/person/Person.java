package dev.accelerated.language.teacher.domain.person;

import dev.accelerated.language.teacher.domain.uuid.InvalidUuidException;
import jakarta.persistence.Entity;
import lombok.Getter;

import java.util.Objects;
import java.util.UUID;

@Getter
@Entity
public class Person {
    @jakarta.persistence.Id
    private UUID id;
    private String firstName;
    private String lastName;

    protected Person() {
    }

    public Person(UUID id, String firstName, String lastName) {
        if (id.version() != 7) {
            throw new InvalidUuidException(id.toString());
        }

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }

    public void rename(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
