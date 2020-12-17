package com.jacoblucas.adventofcode2020.day16;

import com.jacoblucas.adventofcode2020.utils.ImmutablePair;
import com.jacoblucas.adventofcode2020.utils.InputReader;
import com.jacoblucas.adventofcode2020.utils.Pair;
import io.vavr.control.Try;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Day16 {
    public static void main(String[] args) throws IOException {
        final List<String> lines = InputReader.read("day16-input.txt");

        final int ticketIdx = lines.indexOf("your ticket:");
        final List<String> ruleStrs = lines.subList(0, ticketIdx - 1);
        final List<String> nearbyTickets = lines.subList(ticketIdx + 4, lines.size());

        final List<Rule> rules = ruleStrs.stream()
                .map(Rule::parse)
                .filter(Try::isSuccess)
                .map(Try::get)
                .collect(Collectors.toList());

        final int errorRate = validate(nearbyTickets, rules);
        System.out.println(errorRate);

        final List<String> validTickets = nearbyTickets.stream()
                .filter(t -> isValid(t, rules) == 0)
                .collect(Collectors.toList());

        final List<Integer> ticketStr = toTicketValues(lines.get(ticketIdx + 1));
        final List<Pair<Rule, Integer>> fields = getFields(validTickets, rules)
                .stream()
                .sorted(Comparator.comparing(Pair::getSecond))
                .collect(Collectors.toList());

        long result = 1;
        for (int i=0; i<fields.size(); i++) {
            final String field = fields.get(i).getFirst().getField();
            final long value = ticketStr.get(i);
            if (field.startsWith("departure")) {
                result *= value;
            }
        }
        System.out.println(result);
    }

    public static int validate(final List<String> tickets, final List<Rule> rules) {
        return tickets.stream()
                .mapToInt(t -> isValid(t, rules))
                .sum();
    }

    public static int isValid(final String ticket, final List<Rule> rules) {
        final List<Integer> fields = toTicketValues(ticket);

        for (final int field : fields) {
            if (rules.stream().noneMatch(r -> r.isValid(field))) {
                return field;
            }
        }

        return 0;
    }

    private static List<Integer> toTicketValues(String ticket) {
        return Arrays.stream(ticket.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    // need to find orderings of the rules such that all orders validate all fields
    // some of the rules will match only one field, some will match more, can lock in the fields
    // one by one then use process of elimination to lock in the rest
    public static List<Pair<Rule, Integer>> getFields(final List<String> tickets, final List<Rule> rules) {
        final Set<Rule> foundRules = new HashSet<>();
        final List<Pair<Rule, Integer>> result = new ArrayList<>();
        final int fields = rules.size();
        while (result.size() < fields) {
            for (int i = 0; i < fields; i++) {
                final int idx = i;
                final List<Integer> fieldsAtIndex = tickets.stream()
                        .map(t -> t.split(","))
                        .map(arr -> arr[idx])
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

                final List<Rule> matches = rules.stream()
                        .filter(rule -> !foundRules.contains(rule))
                        .filter(rule -> fieldsAtIndex.stream().allMatch(rule::isValid))
                        .collect(Collectors.toList());
                if (matches.size() == 1) {
                    // found
                    final Rule rule = matches.get(0);
                    foundRules.add(rule);
                    result.add(ImmutablePair.of(rule, idx));
                    break;
                }
            }
        }
        return result;
    }
}
