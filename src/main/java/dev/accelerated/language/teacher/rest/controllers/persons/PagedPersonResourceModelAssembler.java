package dev.accelerated.language.teacher.rest.controllers.persons;

import dev.accelerated.language.teacher.DataLoader;
import dev.accelerated.language.teacher.domain.person.Person;
import jakarta.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.web.HateoasPageableHandlerMethodArgumentResolver;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.web.util.UriComponentsBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class PagedPersonResourceModelAssembler extends PagedResourcesAssembler<Person> {

    private static final Logger logger = LoggerFactory.getLogger(DataLoader.class);

    public PagedPersonResourceModelAssembler() {
        super(
                new HateoasPageableHandlerMethodArgumentResolver(),
                UriComponentsBuilder.newInstance().build()
        );
    }

    public <R extends RepresentationModel<?>> CollectionModel<R> toPagedPersonModel(@NotNull Page<Person> page, RepresentationModelAssembler<Person, R> assembler) {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder
                .fromUriString(linkTo(methodOn(PersonController.class).all(page.getPageable())).toUri().toString())
                .queryParam("page", page.getPageable().getPageNumber())
                .queryParam("size", page.getPageable().getPageSize());
        Link selfLink = Link.of(uriBuilder.toUriString()).withSelfRel();
        Link registerLink = Link.of(uriBuilder.toUriString()).withRel("register");
        Link personsLink = Link.of(uriBuilder.toUriString()).withRel("persons");

        return this.toModel(
                page,
                assembler,
                selfLink
        ).add(
                registerLink,
                personsLink
        );
    }
}
