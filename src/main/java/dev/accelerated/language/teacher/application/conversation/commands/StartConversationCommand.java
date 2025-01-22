package dev.accelerated.language.teacher.application.conversation.commands;

import java.util.UUID;

/**
 * @param controllerId UUID  Identifies the person that controls the conversation
 */
public record StartConversationCommand(
        UUID controllerId
) {
}
