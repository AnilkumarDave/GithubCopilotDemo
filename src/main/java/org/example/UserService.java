package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserService {
    private List<User> users = new ArrayList<>();

    public User createUser(String email, String name) throws ValidationException {
        User user = new User(email, name);
        UserValidator.validateUser(user);
        
        user.setId(UUID.randomUUID().toString());
        users.add(user);
        return user;
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

    public User getUserByEmail(String email) {
        return users.stream()
                .filter(u -> u.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }
}
