package dev.accelerated.language.teacher.application.person.commands;

public record RegisterPersonCommand(String firstName, String lastName) {
    @Override
    public String toString() {
        return String.format(
                "RegisterPersonCommand { firstName = '%s', lastName = '%s'}",
                firstName, lastName
        );
    }
}
