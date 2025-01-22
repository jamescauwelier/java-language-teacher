package dev.accelerated.language.teacher.application.conversation;

import dev.accelerated.language.teacher.application.conversation.commands.StartConversationCommand;
import dev.accelerated.language.teacher.domain.conversation.Conversation;
import dev.accelerated.language.teacher.domain.conversation.ConversationCollectionPort;
import dev.accelerated.language.teacher.domain.uuid.UUIDGeneratorPort;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@AllArgsConstructor
@Component
public class ConversationService {
    ConversationCollectionPort collection;
    UUIDGeneratorPort uuidGenerator;

    @Transactional
    public Conversation startConversation(StartConversationCommand command) {
        var conversation = new Conversation(
                uuidGenerator.generate(),
                command.controller()
        );
        return collection.add(conversation);
    }
}
