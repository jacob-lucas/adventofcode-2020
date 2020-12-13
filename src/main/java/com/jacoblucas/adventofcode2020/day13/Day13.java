package com.jacoblucas.adventofcode2020.day13;

import com.jacoblucas.adventofcode2020.utils.InputReader;
import com.jacoblucas.adventofcode2020.utils.Pair;

import java.io.IOException;
import java.util.List;

public class Day13 {
    public static void main(String[] args) throws IOException {
        final List<String> lines = InputReader.read("day13-input.txt");
        final int timestamp = Integer.parseInt(lines.get(0));
        final Timetable timetable = Timetable.parse(lines.get(1));

        final Pair<Bus, Integer> next = timetable.next(timestamp);
        final Bus bus = next.getFirst();
        System.out.println(bus + " departs " + next.getSecond() + " minutes after " + timestamp);
        System.out.println(bus.getId() * next.getSecond());
    }
}
