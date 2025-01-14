package dev.accelerated.language.teacher.domain.uuid;

public class InvalidUuidException extends RuntimeException {
    public InvalidUuidException(String uuid) {
        super("An Id must be a valid UUID v7, but got '" + uuid + "' instead");
    }
}
