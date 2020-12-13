package com.jacoblucas.adventofcode2020.day13;

import com.google.common.collect.Maps;
import com.jacoblucas.adventofcode2020.utils.ImmutablePair;
import com.jacoblucas.adventofcode2020.utils.Pair;
import io.vavr.collection.Stream;
import io.vavr.control.Try;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class Timetable {
    private final Map<Integer, Bus> buses;

    public Timetable(final Map<Integer, Bus> buses) {
        this.buses = buses;
    }

    public Map<Integer, Bus> getBusesById() {
        return buses;
    }

    public Pair<Bus, Integer> next(final int timestamp) {
        final AtomicInteger time = new AtomicInteger(timestamp);
        while (true) {
            final Optional<Bus> schedule = buses.values().stream()
                    .filter(bus -> time.get() % bus.getId() == 0)
                    .findFirst();
            if (schedule.isPresent()) {
                return ImmutablePair.of(schedule.get(), time.get() - timestamp);
            } else {
                time.getAndIncrement();
            }
        }
    }

    public static Timetable parse(final String input) {
        final Stream<Bus> buses = Stream.of(input.split(","))
                .map(Bus::parse)
                .filter(Try::isSuccess)
                .map(Try::get);

        return new Timetable(Maps.uniqueIndex(buses, Bus::getId));
    }
}
