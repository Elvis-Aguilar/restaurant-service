package com.eatsleep.restaurant.config.infrastructure.web;

import java.util.List;

import com.eatsleep.restaurant.config.infrastructure.annotation.CurrentUser;
import com.eatsleep.restaurant.config.infrastructure.client.AuthClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.MethodParameter;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor(onConstructor_ = @Lazy)
public class WebConfig implements WebMvcConfigurer {

    private final AuthClient authClient;

    @Override
    public void addArgumentResolvers(@NonNull List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new CurrentUserArgumentResolver(authClient));
    }
}

@RequiredArgsConstructor
class CurrentUserArgumentResolver implements HandlerMethodArgumentResolver {

    private final AuthClient authClient;

    @Override
    public boolean supportsParameter(@NonNull MethodParameter parameter) {
        return parameter.hasParameterAnnotation(CurrentUser.class);
    }

    @Override
    public Object resolveArgument(@NonNull MethodParameter parameter, @Nullable ModelAndViewContainer mavContainer,
                                  @NonNull NativeWebRequest webRequest, @Nullable WebDataBinderFactory binderFactory) {
        Class<?> dtoType = parameter.getParameterType();
        if (!dtoType.equals(UserDto.class)) {
            throw new IllegalArgumentException("Solo se puede utilizar la anotación @CurrentUser con UserDto");
        }
        return authClient.findCurrentUser();
    }
}
