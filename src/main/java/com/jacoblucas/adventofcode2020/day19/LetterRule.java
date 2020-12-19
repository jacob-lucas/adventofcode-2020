package com.jacoblucas.adventofcode2020.day19;

import org.immutables.value.Value;

import java.util.Map;

@Value.Immutable
public abstract class LetterRule extends Rule {
    @Override
    public abstract int getId();

    public abstract char getLetter();

    @Override
    public String resolvePattern(final Map<Integer, Rule> ruleMap) {
        return String.valueOf(getLetter());
    }
}
