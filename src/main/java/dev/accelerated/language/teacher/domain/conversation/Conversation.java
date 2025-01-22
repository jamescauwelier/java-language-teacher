package dev.accelerated.language.teacher.domain.conversation;

import dev.accelerated.language.teacher.domain.person.Person;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Conversation {
    @Id
    UUID conversationId;
    Participant controller;

    /**
     * JPA constructor
     */
    protected Conversation() {
    }

    /**
     * Default proper constructor
     *
     * @param conversationId UUID Identifies the conversation.
     * @param controller     Person The person that created and thus
     *                       controls the conversation. This takes a `Person`,
     *                       because a `Participant` cannot exist without a
     *                       `Conversation` existing, so these must be created at
     *                       the same time.
     */
    public Conversation(UUID conversationId, Person controller) {
        this.conversationId = conversationId;
        this.controller = new Participant(
                controller.id(),
                String.format("%s %s", controller.firstName(), controller.lastName())
        );
    }

    public UUID id() {
        return conversationId;
    }

    public Participant controller() {
        return controller;
    }
}
