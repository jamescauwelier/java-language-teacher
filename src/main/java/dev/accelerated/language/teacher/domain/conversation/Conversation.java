package dev.accelerated.language.teacher.domain.conversation;

import lombok.With;

public record Conversation(Long id, @With String description) {
}
