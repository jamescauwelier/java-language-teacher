package dev.accelerated.language.teacher.domain.conversation;

import dev.accelerated.language.teacher.domain.uuid.HardcodedUUIDGeneratorAdapter;
import dev.accelerated.language.teacher.domain.uuid.UUIDGeneratorPort;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParticipantTest {
    protected UUIDGeneratorPort uuid = new HardcodedUUIDGeneratorAdapter();

    @Nested
    class AParticipant {
        UUID personId = uuid.generate();
        String displayName = "John Wayne";
        Participant participant = new Participant(personId, displayName);

        @Test
        void hasAPersonId() {
            assertEquals(personId, participant.personId());
        }

        @Test
        void hasADisplayName() {
            assertEquals(displayName, participant.displayName());
        }
    }
}
