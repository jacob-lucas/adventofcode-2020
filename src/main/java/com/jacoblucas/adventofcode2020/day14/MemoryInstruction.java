package com.jacoblucas.adventofcode2020.day14;

import org.immutables.value.Value;

@Value.Immutable
@Value.Style(allParameters = true)
public abstract class MemoryInstruction implements Instruction {
    public abstract int getAddress();

    public abstract int getValue();

    @Override
    public void set(final Program program) {
        program.write(getAddress(), getValue());
    }
}
