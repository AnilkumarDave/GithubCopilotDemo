package org.example;

public class UserValidator {
    
    public static void validateUser(User user) throws ValidationException {
        if (user == null) {
            throw new ValidationException("User object cannot be null");
        }
        
        if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
            throw new ValidationException("Email cannot be empty");
        }
        
        if (!isValidEmail(user.getEmail())) {
            throw new ValidationException("Email format is invalid");
        }
        
        if (user.getName() == null || user.getName().trim().isEmpty()) {
            throw new ValidationException("Name cannot be empty");
        }
    }
    
    private static boolean isValidEmail(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
}
