package dev.accelerated.language.teacher.domain.person;

import dev.accelerated.language.teacher.domain.id.Id;
import lombok.Getter;

import java.util.Objects;

@Getter
public class Person {
    private final Id id;
    private final String firstName;
    private final String lastName;

    public Person(Id id, String firstName, String lastName) {
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
}
