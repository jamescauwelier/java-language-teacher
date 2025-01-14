package dev.accelerated.language.teacher.domain.id;

public class InvalidIdException extends RuntimeException {
    InvalidIdException(String uuid) {
        super("An Id must be a valid UUID v7, but got '" + uuid + "' instead");
    }
}
