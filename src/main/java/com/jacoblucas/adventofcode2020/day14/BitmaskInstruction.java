package com.jacoblucas.adventofcode2020.day14;

import org.immutables.value.Value;

@Value.Immutable
@Value.Style(allParameters = true)
public abstract class BitmaskInstruction implements Instruction {
    public abstract String getBitmask();

    @Override
    public void set(final Program program) {
        program.setBitmask(getBitmask());
    }
}
