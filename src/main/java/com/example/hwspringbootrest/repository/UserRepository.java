package com.example.hwspringbootrest.repository;

import com.example.hwspringbootrest.model.Authorities;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    public List<Authorities> getUserAuthorities(String user, String password) {
        List<Authorities> authoritiesList = new ArrayList<>();
        if (user.equals("admin") && password.equals("1234")) {
            authoritiesList.add(Authorities.READ);
            authoritiesList.add(Authorities.WRITE);
            authoritiesList.add(Authorities.DELETE);
        }
        return authoritiesList;
    }
}
