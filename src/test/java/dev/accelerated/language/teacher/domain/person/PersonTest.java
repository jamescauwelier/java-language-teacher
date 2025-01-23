package dev.accelerated.language.teacher.domain.person;

import dev.accelerated.language.teacher.domain.conversation.Conversation;
import dev.accelerated.language.teacher.domain.uuid.HardcodedUUIDGeneratorAdapter;
import dev.accelerated.language.teacher.domain.uuid.UUIDGeneratorPort;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonTest {

    protected UUIDGeneratorPort uuid = new HardcodedUUIDGeneratorAdapter();

    @Nested
    class APerson {

        Person defaultPerson = new Person(
                uuid.generate(),
                "Anthony",
                "Hopkins"
        );

        @Test
        void hasAnId() {
            assertEquals("01946191-8adb-7997-85d9-6d9279bd0d89", defaultPerson.id().toString());
        }

        @Test
        void hasAFirstName() {
            assertEquals("Anthony", defaultPerson.firstName());
        }

        @Test
        void hasALastName() {
            assertEquals("Hopkins", defaultPerson.lastName());
        }

        @Test
        void hasADisplayName() {
            assertEquals("Anthony Hopkins", defaultPerson.displayName());
        }

        @Test
        void canStartAConversation() {
            var conversation = defaultPerson.startsConversation(uuid.generate());
            assertTrue(conversation instanceof Conversation);
        }
    }
}
