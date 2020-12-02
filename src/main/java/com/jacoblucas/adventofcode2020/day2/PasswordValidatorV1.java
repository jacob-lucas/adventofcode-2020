package com.jacoblucas.adventofcode2020.day2;

import java.util.HashMap;
import java.util.Map;

public class PasswordValidatorV1 implements PasswordValidator {
    @Override
    public boolean isValid(String password, PasswordPolicy policy) {
        final Map<Character, Integer> charCountMap = new HashMap<>();
        for (final char c : password.toCharArray()) {
            if (charCountMap.containsKey(c)) {
                charCountMap.put(c, charCountMap.get(c) + 1);
            } else {
                charCountMap.put(c, 1);
            }
        }

        final int count = charCountMap.getOrDefault(policy.getLetter(), 0);
        return count >= policy.getMinimum() && count <= policy.getMaximum();
    }
}
