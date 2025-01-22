package dev.accelerated.language.teacher.infrastructure.conversation;

import dev.accelerated.language.teacher.domain.conversation.Conversation;
import dev.accelerated.language.teacher.domain.conversation.ConversationCollectionPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Component
public class ConversationCollectionJpaAdapter implements ConversationCollectionPort {
    ConversationRepository repository;

    @Override
    public Conversation add(Conversation conversation) {
        return this.repository.save(conversation);
    }

    @Override
    public Optional<Conversation> get(UUID conversationId) {
        return this.repository.findById(conversationId);
    }
}
