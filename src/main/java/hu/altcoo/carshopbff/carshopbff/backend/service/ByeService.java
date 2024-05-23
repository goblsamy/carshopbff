package hu.altcoo.carshopbff.carshopbff.backend.service;

import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class ByeService implements Serializable {

    public String greet(String name) {
        if (name == null || name.isEmpty()) {
            return "Bye anonymous user";
        } else {
            return "Bye " + name;
        }
    }

}
