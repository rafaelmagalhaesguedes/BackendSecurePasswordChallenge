package com.rafa.security.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class PasswordService {

    private static final String LENGTH_ERROR = "A senha deve possuir pelo menos 08 caracteres.";
    private static final String UPPERCASE_ERROR = "A senha deve possuir pelo menos uma letra maiúscula.";
    private static final String LOWERCASE_ERROR = "A senha deve possuir pelo menos uma letra minúscula.";
    private static final String NUMBER_ERROR = "A senha deve possuir pelo menos um número.";
    private static final String SPECIAL_CHAR_ERROR = "A senha deve possuir pelo menos um caractere especial.";

    public List<String> validatePassword(String password) {
        List<String> errors = new ArrayList<>();

        validateLength(password, errors);
        validateUppercase(password, errors);
        validateLowercase(password, errors);
        validateNumber(password, errors);
        validateSpecialChars(password, errors);

        return errors;
    }

    private static void validateLength(String password, List<String> errors) {
        if (password == null || password.length() < 8) {
            errors.add(LENGTH_ERROR);
        }
    }

    private static void validateUppercase(String password, List<String> errors) {
        if (!Pattern.compile("[A-Z]").matcher(password).find()) {
            errors.add(UPPERCASE_ERROR);
        }
    }

    private static void validateLowercase(String password, List<String> errors) {
        if (!Pattern.compile("[a-z]").matcher(password).find()) {
            errors.add(LOWERCASE_ERROR);
        }
    }

    private static void validateNumber(String password, List<String> errors) {
        if (!Pattern.compile("[0-9]").matcher(password).find()) {
            errors.add(NUMBER_ERROR);
        }
    }

    private static void validateSpecialChars(String password, List<String> errors) {
        if (!Pattern.compile("[\\W]").matcher(password).find()) {
            errors.add(SPECIAL_CHAR_ERROR);
        }
    }
}