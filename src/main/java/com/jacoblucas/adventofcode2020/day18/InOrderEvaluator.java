package com.jacoblucas.adventofcode2020.day18;

public class InOrderEvaluator extends Evaluator {
    @Override
    public long evaluateSingle(final String expression) {
        final String[] parts = expression.split(" ");
        long result = 0L;
        char op = ' ';
        for (final String str : parts) {
            final char ch = str.charAt(0);
            if (ch == ADD || ch == MULTIPLY) {
                op = ch;
            } else {
                final long elem = Long.parseLong(str);
                if (op == ADD) {
                    result += elem;
                } else if (op == MULTIPLY) {
                    result *= elem;
                } else {
                    result = elem;
                }
            }
        }
        return result;
    }
}
