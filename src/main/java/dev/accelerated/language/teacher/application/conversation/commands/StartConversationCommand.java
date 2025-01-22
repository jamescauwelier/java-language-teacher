package dev.accelerated.language.teacher.application.conversation.commands;

import dev.accelerated.language.teacher.domain.person.Person;

/**
 * @param controller Person that controls the conversation
 */
public record StartConversationCommand(
        Person controller
) {
}
