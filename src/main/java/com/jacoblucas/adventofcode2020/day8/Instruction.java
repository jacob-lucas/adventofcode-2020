package com.jacoblucas.adventofcode2020.day8;

import io.vavr.control.Try;
import org.immutables.value.Value;

@Value.Immutable
@Value.Style(allParameters = true)
public abstract class Instruction {
    public abstract Operation getOperation();

    public abstract int getArgument();

    public static Try<Instruction> parse(final String str) {
        return Try.of(() -> {
           final String[] parts = str.split(" ");
           final Operation operation = Operation.valueOf(parts[0].toUpperCase());

           final int sign = parts[1].charAt(0) == '+' ? 1 : -1;
           final int argument = Integer.parseInt(parts[1].substring(1));

           return ImmutableInstruction.builder()
                   .operation(operation)
                   .argument(sign * argument)
                   .build();
        });
    }
}
