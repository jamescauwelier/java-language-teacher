package dev.accelerated.language.teacher.domain.person;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.accelerated.language.teacher.domain.conversation.Conversation;
import dev.accelerated.language.teacher.domain.uuid.InvalidUuidException;
import jakarta.persistence.Entity;

import java.util.Objects;
import java.util.UUID;

@Entity
public class Person {
    @jakarta.persistence.Id
    private UUID id;
    private String firstName;
    private String lastName;

    /**
     * Note: this constructor is needed for JPA access. Preferably, this
     * would not exist as an empty `Person` makes no sense and should
     * not exist.
     */
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

    @JsonProperty("id")
    public UUID id() {
        return id;
    }

    @JsonProperty("firstName")
    public String firstName() {
        return firstName;
    }

    @JsonProperty("lastName")
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
