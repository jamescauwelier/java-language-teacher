package dev.accelerated.language.teacher.domain.conversation;

import java.util.Optional;
import java.util.UUID;

public interface ConversationCollectionPort {
    /**
     * Add a conversation to a collection to effectively persist it accross
     * requests
     *
     * @param conversation A conversation domain object
     * @return Conversation
     */
    Conversation add(Conversation conversation);

    /**
     * Fetches a conversation identified by `conversationId` or returns
     * nothing if it wasn't found.
     *
     * @param conversationId Identifies which conversation to fetch
     * @return Optional<Conversation>
     */
    Optional<Conversation> get(UUID conversationId);
}
