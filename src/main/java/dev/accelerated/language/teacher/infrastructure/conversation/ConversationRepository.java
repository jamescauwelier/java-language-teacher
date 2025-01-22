package dev.accelerated.language.teacher.infrastructure.conversation;

import dev.accelerated.language.teacher.domain.conversation.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public interface ConversationRepository extends JpaRepository<Conversation, UUID> {
}
