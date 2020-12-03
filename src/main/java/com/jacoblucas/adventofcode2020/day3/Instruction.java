package com.jacoblucas.adventofcode2020.day3;

import org.immutables.value.Value;

@Value.Immutable
@Value.Style(allParameters = true)
public abstract class Instruction {
    public abstract Direction getDirection();

    public abstract int getAmount();
}
