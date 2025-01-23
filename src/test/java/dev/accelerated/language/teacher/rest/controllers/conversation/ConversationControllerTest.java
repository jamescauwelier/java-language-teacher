package dev.accelerated.language.teacher.rest.controllers.conversation;

import dev.accelerated.language.teacher.application.person.PersonService;
import dev.accelerated.language.teacher.application.person.commands.RegisterPersonCommand;
import dev.accelerated.language.teacher.domain.person.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.hamcrest.Matchers.matchesPattern;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ConversationControllerTest {
    @Autowired
    PersonService personService;

    @Autowired
    protected MockMvc mockMvc;

    @Nested
    class StartConversationRequest {
        Person person;
        RequestBuilder request;

        @BeforeEach
        void initializeDefaultRequest() {
            person = personService.registerPerson(new RegisterPersonCommand("John", "Wayne"));
            request = post(String.format("/persons/%s/conversations", person.id().toString()))
                    .header("X-Person-Id", person.id().toString())
                    .contentType(MediaType.APPLICATION_JSON);
        }

        @Test
        void returnsTheRightContentType() throws Exception {
            mockMvc
                    .perform(request)
                    .andExpect(content().contentType("application/hal+json"));
        }

        @Test
        void returnsTheRightStatusCode() throws Exception {
            mockMvc
                    .perform(request)
                    .andExpect(status().isCreated());
        }

        @Test
        void returnsConversationDetails() throws Exception {
            mockMvc
                    .perform(request)
                    .andExpect(jsonPath("$.id").exists())
                    .andExpect(jsonPath("$.role").value("controller"));
        }

        @Test
        void returnsHateoasLinks() throws Exception {
            mockMvc
                    .perform(request)
                    .andExpect(jsonPath("$._links.self.href").value(matchesPattern("^https?://localhost(:[0-9]+)?/conversations/[a-f0-9]+-[a-f0-9]+-[a-f0-9]+-[a-f0-9]+-[a-f0-9]+$")));
        }
    }
}
