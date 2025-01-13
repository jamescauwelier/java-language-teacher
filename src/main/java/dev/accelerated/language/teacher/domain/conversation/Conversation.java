package dev.accelerated.language.teacher.domain.conversation;

import lombok.With;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

@Log
@Component
public record Conversation(Long id, @With String description) {
}
