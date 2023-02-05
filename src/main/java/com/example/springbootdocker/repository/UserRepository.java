package com.example.springbootdocker.repository;

import com.example.springbootdocker.model.Authorities;
import com.example.springbootdocker.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class UserRepository {
    private List<Person> persons = new ArrayList<>();

    public UserRepository() {
        persons.add(new Person("admin", "12345678",
                Arrays.asList(Authorities.READ, Authorities.WRITE, Authorities.DELETE)));

        persons.add(new Person("user1", "user1234",
                List.of(Authorities.READ)));

        persons.add(new Person("user2", "user21234",
                Arrays.asList(Authorities.READ, Authorities.WRITE)));
    }

    public List<Authorities> getUserAuthorities(Person person) {
        int index = persons.indexOf(person);
        if (index != -1) {
            return persons.get(index).getAuthoritiesList();
        }
        return null;
    }
}
