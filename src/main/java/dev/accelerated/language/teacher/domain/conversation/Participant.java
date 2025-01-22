package dev.accelerated.language.teacher.domain.conversation;

import jakarta.persistence.Embeddable;

import java.util.Objects;
import java.util.UUID;

@Embeddable
public class Participant {
    UUID personId;
    String displayName;

    protected Participant() {
    }

    Participant(
            UUID personId,
            String displayName
    ) {
        this.personId = personId;
        this.displayName = displayName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return Objects.equals(personId, that.personId) && Objects.equals(displayName, that.displayName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, displayName);
    }
}
