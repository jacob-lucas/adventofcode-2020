package com.jacoblucas.adventofcode2020.day2;

public interface PasswordValidator {
    boolean isValid(final String password, final PasswordPolicy policy);
}
