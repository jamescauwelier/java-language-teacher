package dev.accelerated.language.teacher.application.conversation;

import dev.accelerated.language.teacher.TestConfig;
import dev.accelerated.language.teacher.application.conversation.commands.StartConversationCommand;
import dev.accelerated.language.teacher.application.person.PersonService;
import dev.accelerated.language.teacher.application.person.commands.RegisterPersonCommand;
import dev.accelerated.language.teacher.domain.conversation.Conversation;
import dev.accelerated.language.teacher.domain.person.Person;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Import(TestConfig.class)
public class ConversationServiceTest {
    @Autowired
    protected PersonService personService;

    @Autowired
    protected ConversationService conversationService;

    @Nested
    class WhenAConversationStarts {
        Person person = personService.registerPerson(
                new RegisterPersonCommand("John", "Wayne")
        );
        Conversation conversation = conversationService.startConversation(
                new StartConversationCommand(person.id().toString())
        );

        @Test
        void itHasAConversationId() {
            assertNotNull(conversation.id());
        }

        @Test
        void itHasAControllerWithAPersonIdCopiesFromTheCreatingPerson() {
            assertEquals(person.id(), conversation.controller().personId());
        }

        @Test
        void itHasAControllerWithADisplayNameCopiedFromTheCreatingPerson() {
            assertEquals(person.displayName(), conversation.controller().displayName());
        }
    }
}
