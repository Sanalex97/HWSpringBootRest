package com.example.hwspringbootrest.model;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
public class CasePersonHandlerMethodArgumentResolver implements org.springframework.web.method.support.HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        if (parameter.getParameterType() == Person.class
                && parameter.hasParameterAnnotation(CasePerson.class)
        ) {
            return true;
        }
        return false;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        Person person = new Person(webRequest.getParameter("user"), webRequest.getParameter("password"));
        return person;
    }
}
