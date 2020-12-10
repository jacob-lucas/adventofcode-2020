package com.jacoblucas.adventofcode2020.day10;

import com.google.common.base.Preconditions;
import org.immutables.value.Value;

@Value.Immutable
@Value.Style(allParameters = true)
public abstract class JoltageAdapter {
    public abstract int getOutput();

    public boolean isValidInput(final int input) {
        final int delta = getOutput() - input;
        return delta > 0 && delta < 4;
    }

    @Value.Check
    public void check() {
        Preconditions.checkArgument(getOutput() >= 0, "Rating must be 0 or greater");
    }
}
