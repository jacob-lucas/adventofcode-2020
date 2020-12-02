package com.jacoblucas.adventofcode2020.day2;

import org.immutables.value.Value;

@Value.Immutable
public abstract class PasswordPolicy {
    public abstract char getLetter();

    public abstract int getMinimum();

    public abstract int getMaximum();
}
