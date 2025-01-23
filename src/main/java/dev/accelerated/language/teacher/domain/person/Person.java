package dev.accelerated.language.teacher.domain.person;

import dev.accelerated.language.teacher.domain.conversation.Conversation;
import dev.accelerated.language.teacher.domain.uuid.InvalidUuidException;

import java.util.Objects;
import java.util.UUID;

public class Person {
    private UUID id;
    private String firstName;
    private String lastName;

    public Person(UUID id, String firstName, String lastName) {
        if (id.version() != 7) {
            throw new InvalidUuidException(id.toString());
        }

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public UUID id() {
        return id;
    }

    public String firstName() {
        return firstName;
    }

    public String lastName() {
        return lastName;
    }

    public String displayName() {
        return String.format("%s %s", firstName, lastName);
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

    @Override
    public String toString() {
        return String.format(
                "Person { id = '%s', firstName = '%s', lastName = '%s'}",
                id, firstName, lastName
        );
    }

    public Conversation startsConversation(UUID conversationId) {
        return new Conversation(
                conversationId,
                this
        );
    }
}
