package dev.accelerated.language.teacher.application.conversation;

import dev.accelerated.language.teacher.application.conversation.commands.StartConversationCommand;
import dev.accelerated.language.teacher.domain.conversation.Conversation;
import dev.accelerated.language.teacher.domain.conversation.ConversationCollectionPort;
import dev.accelerated.language.teacher.domain.person.PersonCollectionPort;
import dev.accelerated.language.teacher.domain.uuid.UUIDGeneratorPort;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;


@AllArgsConstructor
@Component
public class ConversationService {
    PersonCollectionPort persons;
    ConversationCollectionPort conversations;
    UUIDGeneratorPort uuidGenerator;

    @Transactional
    public Conversation startConversation(StartConversationCommand command) {
        UUID controllerId = UUID.fromString(command.controllerId());
        var controller = persons.getRequired(controllerId);

        var conversation = new Conversation(
                uuidGenerator.generate(),
                controller
        );
        return conversations.add(conversation);
    }
}
