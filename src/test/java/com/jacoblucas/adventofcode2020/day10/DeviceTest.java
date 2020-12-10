package com.jacoblucas.adventofcode2020.day10;

import com.google.common.collect.ImmutableList;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DeviceTest {
    private Device device;

    @Before
    public void setUp() {
        device = new Device();
    }

    @Test
    public void testGetBuiltInAdapterEmptyList() {
        final JoltageAdapter builtInAdapter = device.getBuiltInAdapter(ImmutableList.of());
        assertThat(builtInAdapter.getOutput(), is(3));
    }

    @Test
    public void testGetBuiltInAdapter() {
        final JoltageAdapter builtInAdapter = device.getBuiltInAdapter(ImmutableList.of(
                ImmutableJoltageAdapter.of(3), ImmutableJoltageAdapter.of(9), ImmutableJoltageAdapter.of(6)));
        assertThat(builtInAdapter.getOutput(), is(12));
    }
}
