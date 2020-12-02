package com.jacoblucas.adventofcode2020.day2;

import org.immutables.value.Value;

import java.util.HashMap;
import java.util.Map;

@Value.Immutable
public abstract class PasswordPolicy {
    public abstract char getLetter();

    public abstract int getMinimum();

    public abstract int getMaximum();

    public boolean isValid(final String password) {
        final Map<Character, Integer> charCountMap = new HashMap<>();
        for (final char c : password.toCharArray()) {
            if (charCountMap.containsKey(c)) {
                charCountMap.put(c, charCountMap.get(c) + 1);
            } else {
                charCountMap.put(c, 1);
            }
        }

        final int count = charCountMap.getOrDefault(getLetter(), 0);
        return count >= getMinimum() && count <= getMaximum();
    }
}
