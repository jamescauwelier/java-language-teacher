package dev.accelerated.language.teacher.domain.id;

import java.util.UUID;

public class InvalidIdException extends RuntimeException {
    InvalidIdException(UUID uuid) {
        super("An Id must be a valid UUID v7, but got '" + uuid.toString() + "' instead");
    }
}
