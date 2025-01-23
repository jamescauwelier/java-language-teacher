package dev.accelerated.language.teacher.rest.authentication;

import dev.accelerated.language.teacher.domain.authentication.user.AuthenticatedUser;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.Optional;
import java.util.UUID;

public class AuthenticationResolver implements HandlerMethodArgumentResolver {
    /**
     * Supports the resolution to an `AuthenticatedUser` from header information
     *
     * @param parameter MethodParameter
     * @return boolean Is this type of parameter supported?
     */
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(AuthenticatedUser.class);
    }

    @Override
    @NonNull
    public Object resolveArgument(@NonNull MethodParameter parameter, @NonNull ModelAndViewContainer mavContainer, NativeWebRequest webRequest, @NonNull WebDataBinderFactory binderFactory) throws Exception {
        return Optional.of(webRequest.getHeader("X-Person-Id"))
                .flatMap(
                        s -> {
                            try {
                                return Optional.of(UUID.fromString(s));
                            } catch (Exception e) {
                                return Optional.empty();
                            }
                        }
                )
                .map(AuthenticatedUser::new)
                .orElseThrow(() ->
                        new HttpClientErrorException(HttpStatus.UNAUTHORIZED, "Invalid or missing person id")
                );
    }
}
