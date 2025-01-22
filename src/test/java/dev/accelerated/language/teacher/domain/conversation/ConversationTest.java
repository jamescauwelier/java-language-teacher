package dev.accelerated.language.teacher.domain.conversation;

import dev.accelerated.language.teacher.domain.person.Person;
import dev.accelerated.language.teacher.domain.uuid.HardcodedUUIDGeneratorAdapter;
import dev.accelerated.language.teacher.domain.uuid.UUIDGeneratorPort;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConversationTest {
    protected UUIDGeneratorPort uuid = new HardcodedUUIDGeneratorAdapter();

    @Nested
    class AConversation {
        @Test
        void canBeCreated() {
            new Conversation(
                    uuid.generate(),
                    new Person(uuid.generate(), "First", "Last")
            );
        }

        UUID conversationId = uuid.generate();
        UUID personId = uuid.generate();
        Conversation conversation = new Conversation(
                conversationId,
                new Person(personId, "First", "Last")
        );

        @Test
        void hasAnId() {
            assertEquals(conversationId, conversation.id());
        }

        @Test
        void hasAController() {
            assertEquals(
                    new Participant(personId, "First Last"),
                    conversation.controller()
            );
        }
    }
}
