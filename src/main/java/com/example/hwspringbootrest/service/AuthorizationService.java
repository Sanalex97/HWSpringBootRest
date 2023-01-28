package com.example.hwspringbootrest.service;

import com.example.hwspringbootrest.exception.InvalidCredentials;
import com.example.hwspringbootrest.exception.UnauthorizedUser;
import com.example.hwspringbootrest.model.Authorities;
import com.example.hwspringbootrest.model.CasePerson;
import com.example.hwspringbootrest.model.Person;
import com.example.hwspringbootrest.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorizationService {
    UserRepository userRepository;

    public AuthorizationService(UserRepository repository) {
        this.userRepository = repository;
    }

    public List<Authorities> getAuthorities(@CasePerson Person person) {
        if (isEmpty(person.getUser()) || isEmpty(person.getPassword())) {
            throw new InvalidCredentials("User name or password is empty");
        }

        List<Authorities> userAuthorities = userRepository.getUserAuthorities(person);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + person);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
