package com.jacoblucas.adventofcode2020.day10;

import java.util.List;

public class Device {
    // Your device has a built-in joltage adapter rated for 3 jolts higher than the highest-rated adapter in your bag
    public JoltageAdapter getBuiltInAdapter(final List<JoltageAdapter> adapters) {
        int maxOutput = 0;
        if (!adapters.isEmpty()) {
            maxOutput = adapters.stream()
                    .mapToInt(JoltageAdapter::getOutput)
                    .max()
                    .getAsInt();
        }

        return ImmutableJoltageAdapter.of(maxOutput + 3);
    }
}
