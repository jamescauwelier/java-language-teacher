package dev.accelerated.language.teacher.rest.controllers.conversation;

import dev.accelerated.language.teacher.domain.conversation.Conversation;

public record ConversationResource(String id, String role) {
    public static ConversationResource fromConversation(Conversation conversation) {
        return new ConversationResource(
                conversation.id().toString(),
                "controller"
        );
    }
}
