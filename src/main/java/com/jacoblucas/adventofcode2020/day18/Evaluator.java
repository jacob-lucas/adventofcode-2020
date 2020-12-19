package com.jacoblucas.adventofcode2020.day18;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

public abstract class Evaluator {
    protected static final char ADD = '+';
    protected static final char MULTIPLY = '*';

    public long evaluate(final String expression) {
        if (Strings.isNullOrEmpty(expression)) {
            return 0;
        }

        final List<String> subExpressions = split(expression);
        if (subExpressions.size() == 1) {
            return evaluateSingle(expression);
        } else {
            String newExpression = expression;
            for (final String expr : subExpressions) {
                newExpression = newExpression.replace("(" + expr + ")", String.valueOf(evaluate(expr)));
            }
            return evaluate(newExpression);
        }
    }

    public abstract long evaluateSingle(final String expression);

    protected List<String> split(final String expression) {
        if (!expression.contains("(")) {
            return ImmutableList.of(expression);
        }

        final List<String> expressions = new ArrayList<>();
        int startIdx = 0;
        int opens = 0;
        for (int i = 0; i < expression.length(); i++) {
            final char ch = expression.charAt(i);
            if (ch == '(') {
                if (opens == 0) {
                    if (startIdx >= 0 && i > 3 && i > startIdx) {
                        expressions.add(expression.substring(startIdx, i-3));
                    }
                    startIdx = i + 1;
                }
                opens++;
            } else if (ch == ')') {
                opens--;
                if (opens == 0) {
                    expressions.add(expression.substring(startIdx, i));
                    if (i < expression.length() - 1) {
                        startIdx = i + 4;
                    }
                }
            } else if (i == expression.length() - 1) {
                expressions.add(expression.substring(startIdx));
            }
        }

        return expressions;
    }
}
