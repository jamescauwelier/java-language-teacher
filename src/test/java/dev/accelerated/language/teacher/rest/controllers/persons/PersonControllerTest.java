package dev.accelerated.language.teacher.rest.controllers.persons;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.hamcrest.Matchers.matchesPattern;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonControllerTest {
    @Autowired
    PersonController controller;

    @Autowired
    protected MockMvc mockMvc;

    @Nested
    class GetAllPersonsTest {

        private RequestBuilder defaultRequestBuilder = get("/persons");

        @Test
        void testGetAllResponseCode() throws Exception {
            mockMvc
                    .perform(defaultRequestBuilder)
                    .andExpect(status().isOk());
        }

        @Test
        void testContentTypeIsRight() throws Exception {
            mockMvc
                    .perform(defaultRequestBuilder)
                    .andExpect(content().contentType("application/hal+json"));
        }

        @Test
        void testGetAllSelfHateoas() throws Exception {
            mockMvc
                    .perform(defaultRequestBuilder)
                    .andExpect(jsonPath("$._links.self.href").exists());
        }

        @Test
        void testContainsPaginationHateoas() throws Exception {
            mockMvc
                    .perform(get("/persons?page=1&size=1"))
                    .andExpect(jsonPath("$._links.first.href").exists())
                    .andExpect(jsonPath("$._links.last.href").exists())
                    .andExpect(jsonPath("$._links.prev.href").exists())
                    .andExpect(jsonPath("$._links.next.href").exists());
        }

        @Test
        void testGetAllResponseContainsRegisterHateoas() throws Exception {
            mockMvc
                    .perform(defaultRequestBuilder)
                    .andExpect(jsonPath("$._links.register.href").exists());
        }

        @Test
        void testGetAllResponseContainsPersonsHateoas() throws Exception {
            mockMvc
                    .perform(defaultRequestBuilder)
                    .andExpect(jsonPath("$._links.persons.href").exists());
        }

        @Test
        void testGetAllContainsContent() throws Exception {
            mockMvc
                    .perform(defaultRequestBuilder)
                    .andExpect(jsonPath("$._embedded.personList").exists());
        }

        @Test
        void testNotFoundWhenOutOfRange() throws Exception {
            mockMvc
                    .perform(get("/persons?page=1000&size=100"))
                    .andExpect(status().isNotFound());

        }

        @Test
        void testThatContentsIsLimitedInPageSize() throws Exception {
            mockMvc
                    .perform(get("/persons?page=0&size=2"))
                    .andExpect(jsonPath("$._embedded.personList.length()").value(2));

        }
    }

    @Nested
    class RegisterPersonTest {

        String jsonRequestBody = """
                {
                    "firstName": "Sylvie",
                    "lastName": "Stallone"
                }
                """;
        private RequestBuilder request = post("/persons")
                .content(jsonRequestBody)
                .contentType(MediaType.APPLICATION_JSON);

        @Test
        void testRegistrationReturnsProperStatusCode() throws Exception {
            mockMvc
                    .perform(request)
                    .andExpect(status().isCreated());
        }

        @Test
        void testRegistrationReturnsHalJson() throws Exception {
            mockMvc
                    .perform(request)
                    .andExpect(content().contentType("application/hal+json"));
        }

        @Test
        void testRegistrationReturnsPersonDetails() throws Exception {
            mockMvc
                    .perform(request)
                    .andExpect(jsonPath("$.id").exists())
                    .andExpect(jsonPath("$.firstName").value("Sylvie"))
                    .andExpect(jsonPath("$.lastName").value("Stallone"));
        }

        @Test
        void testRegistrationResponseContainsSelfLink() throws Exception {
            mockMvc
                    .perform(request)
                    .andExpect(jsonPath("$._links.self.href").value(matchesPattern("^https?://localhost(:[0-9]+)?/persons/[a-f0-9]+-[a-f0-9]+-[a-f0-9]+-[a-f0-9]+-[a-f0-9]+$")));
        }
    }
}
