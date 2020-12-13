package com.jacoblucas.adventofcode2020.day13;

import com.jacoblucas.adventofcode2020.utils.Pair;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

public class TimetableTest {
    private Timetable timetable;

    @Before
    public void setUp() {
        timetable = Timetable.parse("7,13,x,x,59,x,31,19");
    }

    @Test
    public void testToBusSchedules() {
        assertThat(timetable.getBusesById().values(), containsInAnyOrder(
                ImmutableBus.of(7),
                ImmutableBus.of(13),
                ImmutableBus.of(59),
                ImmutableBus.of(31),
                ImmutableBus.of(19)));
    }

    @Test
    public void testNext() {
        final Pair<Bus, Integer> next = timetable.next(939);
        assertThat(next.getFirst(), is(ImmutableBus.of(59)));
        assertThat(next.getSecond(), is(5));
    }
}
