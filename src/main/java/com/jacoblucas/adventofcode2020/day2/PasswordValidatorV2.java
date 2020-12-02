package com.jacoblucas.adventofcode2020.day2;

public class PasswordValidatorV2 implements PasswordValidator {
    @Override
    public boolean isValid(final String password, final PasswordPolicy policy) {
        final int position1 = policy.getMinimum() - 1;
        final int position2 = policy.getMaximum() - 1;
        return password.charAt(position1) == policy.getLetter() ^ password.charAt(position2) == policy.getLetter();
    }
}
