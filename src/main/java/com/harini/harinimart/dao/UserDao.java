package com.harini.harinimart.dao;

public class UserDao {

    public static boolean validateUser(String email, String password) {
        // Hardcoded admin email and password check directly in code
        String correctEmail = "admin@harinimart.com";
        String correctPassword = "password123";
        
        // Check if the entered email and password match
        if (email != null && password != null) {
            if (email.trim().equals(correctEmail) && password.equals(correctPassword)) {
                return true;
            }
        }
        
        return false;
    }
}