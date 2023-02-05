package com.example.springbootdocker.controller;

import com.example.springbootdocker.model.Authorities;
import com.example.springbootdocker.model.CasePerson;
import com.example.springbootdocker.model.Person;
import com.example.springbootdocker.service.AuthorizationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorizationController {
    AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid @CasePerson Person person) {
        return service.getAuthorities(person);
    }
}
