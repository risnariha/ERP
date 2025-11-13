package com.erp.ERP.Util;



public class ValidationUtil {

    // Validate email format
    public static boolean isEmailValid(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return email != null && email.matches(emailRegex);
    }

    // Check if a string is not null or empty after trimming
    public static boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }

    // Validate that the year field for students is in a valid range (example: 1–4)
    public static boolean isValidYear(int year) {
        return year >= 1 && year <= 4;
    }

    // Validate usernames (example: only alphanumeric, length 3–16 for campus rules)
    public static boolean isUsernameValid(String username) {
        String usernameRegex = "^[A-Za-z0-9]{3,16}$";
        return username != null && username.matches(usernameRegex);
    }

    // Add more custom validation methods as needed...
}
