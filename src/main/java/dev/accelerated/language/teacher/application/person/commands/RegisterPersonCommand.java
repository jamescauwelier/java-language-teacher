package dev.accelerated.language.teacher.application.person.commands;

import jakarta.validation.constraints.NotNull;

public record RegisterPersonCommand(@NotNull String firstName, @NotNull String lastName) {
    @Override
    public String toString() {
        return String.format(
                "RegisterPersonCommand { firstName = '%s', lastName = '%s'}",
                firstName, lastName
        );
    }
}
