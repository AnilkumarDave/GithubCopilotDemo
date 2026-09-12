package org.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UserServiceTest {

    @Test
    public void shouldCreateUserWhenEmailIsValid() throws ValidationException {
        UserService service = new UserService();

        User user = service.createUser("anil@example.com", "Anil");

        assertNotNull(user);
        assertNotNull(user.getId());
        assertEquals("anil@example.com", user.getEmail());
        assertEquals("Anil", user.getName());
    }

    @Test(expected = ValidationException.class)
    public void shouldRejectUserWhenEmailIsEmpty() throws ValidationException {
        UserService service = new UserService();
        service.createUser("", "Anil");
    }

    @Test(expected = ValidationException.class)
    public void shouldRejectUserWhenEmailIsNull() throws ValidationException {
        UserService service = new UserService();
        service.createUser(null, "Anil");
    }

    @Test(expected = ValidationException.class)
    public void shouldRejectUserWhenEmailFormatIsInvalid() throws ValidationException {
        UserService service = new UserService();
        service.createUser("invalid-email", "Anil");
    }
}
