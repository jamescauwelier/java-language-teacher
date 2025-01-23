package dev.accelerated.language.teacher.rest.controllers.conversation;

import dev.accelerated.language.teacher.domain.conversation.Conversation;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ConversationResourceModelAssembler implements RepresentationModelAssembler<Conversation, EntityModel<ConversationResource>> {
    @Override
    @NonNull
    public EntityModel<ConversationResource> toModel(@NonNull Conversation entity) {
        var resource = ConversationResource.fromConversation(entity);
        var model = EntityModel
                .of(resource)
                .add(linkTo(methodOn(ConversationController.class).get(resource.id())).withSelfRel());

        return model;
    }
}
