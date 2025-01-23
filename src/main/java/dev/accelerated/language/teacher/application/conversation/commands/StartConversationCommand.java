package dev.accelerated.language.teacher.application.conversation.commands;

/**
 * @param controllerId UUID  Identifies the person that controls the conversation
 */
public record StartConversationCommand(
        String controllerId
) {
}
