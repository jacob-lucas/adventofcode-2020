package com.jacoblucas.adventofcode2020.day12;

import io.vavr.control.Try;
import org.immutables.value.Value;

@Value.Immutable
@Value.Style(allParameters = true)
public abstract class Instruction {
    public abstract Action getAction();

    public abstract int getValue();

    public static Try<Instruction> parse(final String str) {
        return Try.of(() -> {
           final char ch = str.charAt(0);
           final int value = Integer.parseInt(str.substring(1));
           return ImmutableInstruction.of(Action.of(ch), value);
        });
    }
}
