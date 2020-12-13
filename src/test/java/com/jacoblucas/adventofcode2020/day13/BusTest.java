package com.jacoblucas.adventofcode2020.day13;

import io.vavr.control.Try;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BusTest {
    @Test
    public void testParseInService() {
        final Try<Bus> bus = Bus.parse("52");
        assertThat(bus.get(), is(ImmutableBus.of(52)));
    }

    @Test
    public void testParseOutOfService() {
        final Try<Bus> bus = Bus.parse("x");
        assertThat(bus.isFailure(), is(true));
    }
}
