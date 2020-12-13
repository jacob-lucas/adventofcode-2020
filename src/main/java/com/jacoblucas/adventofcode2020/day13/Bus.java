package com.jacoblucas.adventofcode2020.day13;

import io.vavr.control.Try;
import org.immutables.value.Value;

@Value.Immutable
@Value.Style(allParameters = true)
public abstract class Bus {
    public abstract int getId();

    @Value.Derived
    public int getDuration() {
        return getId();
    }

    public static Try<Bus> parse(final String str) {
        return Try.of(() -> ImmutableBus.of(Integer.parseInt(str)));
    }
}
