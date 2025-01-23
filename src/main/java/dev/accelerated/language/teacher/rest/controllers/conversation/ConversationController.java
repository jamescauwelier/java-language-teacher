package dev.accelerated.language.teacher.rest.controllers.conversation;

import dev.accelerated.language.teacher.application.conversation.ConversationService;
import dev.accelerated.language.teacher.application.conversation.commands.StartConversationCommand;
import dev.accelerated.language.teacher.domain.authentication.user.AuthenticatedUser;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@AllArgsConstructor
@RestController
public class ConversationController {
    ConversationService service;
    ConversationResourceModelAssembler assembler;

    @PostMapping("/persons/{personId}/conversations")
    ResponseEntity<?> startConversation(@PathVariable String personId, AuthenticatedUser user) {
        StartConversationCommand command = new StartConversationCommand(personId);
        var conversation = service.startConversation(command);

        return ResponseEntity
                .created(
                        linkTo(methodOn(ConversationController.class).get(conversation.id().toString())).withSelfRel().toUri()
                )
                .body(assembler.toModel(conversation));

    }

    @GetMapping("/conversations/{conversationId}")
    EmptyResponse get(@PathVariable String conversationId) {
        return new EmptyResponse("todo");
    }
}
