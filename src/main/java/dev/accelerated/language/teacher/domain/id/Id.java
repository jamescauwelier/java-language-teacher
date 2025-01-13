package dev.accelerated.language.teacher.domain.id;

import java.util.Objects;
import java.util.UUID;

public class Id {
    private final UUID uuid;

    public Id(UUID uuid) {
        if (uuid.version() != 7) {
            throw new InvalidIdException(uuid);
        }

        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return uuid.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Id id = (Id) o;
        return Objects.equals(uuid.toString(), id.uuid.toString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid.toString());
    }
}
