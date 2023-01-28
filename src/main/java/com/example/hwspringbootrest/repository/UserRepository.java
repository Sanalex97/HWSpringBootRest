package com.example.hwspringbootrest.repository;

import com.example.hwspringbootrest.model.Authorities;
import com.example.hwspringbootrest.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    public List<Authorities> getUserAuthorities(Person person) {
        List<Authorities> authoritiesList = new ArrayList<>();
        if (person.getUser().equals("admin") && person.getPassword().equals("12345678")) {
            authoritiesList.add(Authorities.READ);
            authoritiesList.add(Authorities.WRITE);
            authoritiesList.add(Authorities.DELETE);
        }
        return authoritiesList;
    }
}
