package com.jacoblucas.adventofcode2020.day18;

import com.google.common.collect.ImmutableSet;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AddFirstEvaluator extends Evaluator {
    @Override
    public long evaluateSingle(final String expression) {
        if (!expression.contains(""+ADD)) {
            return new InOrderEvaluator().evaluateSingle(expression);
        } else {
            String[] parts = expression.split(" ");
            final AtomicInteger index = new AtomicInteger(0);
            for (int i=0; i<parts.length; i++) {
                if (parts[i].charAt(0) == ADD) {
                    index.set(i);
                    break;
                }
            }
            parts[index.get()] = String.valueOf(Long.parseLong(parts[index.get()-1]) + Long.parseLong(parts[index.get()+1]));
            return evaluateSingle(IntStream.range(0, parts.length)
                    .filter(i -> !ImmutableSet.of(index.get() - 1, index.get() + 1).contains(i))
                    .mapToObj(i -> parts[i])
                    .collect(Collectors.joining(" ")));
        }
    }
}
