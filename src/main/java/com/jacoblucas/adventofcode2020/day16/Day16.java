package com.jacoblucas.adventofcode2020.day16;

import com.jacoblucas.adventofcode2020.utils.InputReader;
import io.vavr.control.Try;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day16 {
    public static void main(String[] args) throws IOException {
        final List<String> lines = InputReader.read("day16-input.txt");

        final int ticketIdx = lines.indexOf("your ticket:");
        final List<String> ruleStrs = lines.subList(0, ticketIdx - 1);
        final String ticketStr = lines.get(ticketIdx + 1);
        final List<String> nearbyTickets = lines.subList(ticketIdx + 4, lines.size());

        final List<Rule> rules = ruleStrs.stream()
                .map(Rule::parse)
                .filter(Try::isSuccess)
                .map(Try::get)
                .collect(Collectors.toList());

        final int errorRate = validate(nearbyTickets, rules);
        System.out.println(errorRate);
    }

    public static int validate(final List<String> tickets, final List<Rule> rules) {
        return tickets.stream()
                .mapToInt(t -> isValid(t, rules))
                .sum();
    }

    public static int isValid(final String ticket, final List<Rule> rules) {
        final List<Integer> fields = Arrays.stream(ticket.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        for (final int field : fields) {
            if (rules.stream().noneMatch(r -> r.isValid(field))) {
                return field;
            }
        }

        return 0;
    }
}
