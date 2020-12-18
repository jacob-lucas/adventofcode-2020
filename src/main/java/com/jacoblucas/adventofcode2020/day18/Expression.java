package com.jacoblucas.adventofcode2020.day18;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

public class Expression {
    private static final char ADD = '+';
    private static final char MULTIPLY = '*';

    final String expression;

    public Expression(final String expr) {
        expression = expr;
    }

    public long evaluate() {
        if (Strings.isNullOrEmpty(expression)) {
            return 0;
        }

        final List<Expression> subExpressions = split();
        if (subExpressions.size() == 1) {
            final Expression expr = subExpressions.get(0);
            final String[] parts = expr.expression.split(" ");
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
        } else {
            String newExpression = expression;
            for (final Expression e : subExpressions) {
                newExpression = newExpression.replace("(" + e.expression + ")", String.valueOf(e.evaluate()));
            }
            return new Expression(newExpression).evaluate();
        }
    }

    List<Expression> split() {
        if (!expression.contains("(")) {
            return ImmutableList.of(this);
        }

        final List<Expression> expressions = new ArrayList<>();
        int startIdx = 0;
        int opens = 0;
        for (int i = 0; i < expression.length(); i++) {
            final char ch = expression.charAt(i);
            if (ch == '(') {
                if (opens == 0) {
                    if (startIdx >= 0 && i > 3 && i > startIdx) {
                        expressions.add(new Expression(expression.substring(startIdx, i-3)));
                    }
                    startIdx = i + 1;
                }
                opens++;
            } else if (ch == ')') {
                opens--;
                if (opens == 0) {
                    expressions.add(new Expression(expression.substring(startIdx, i)));
                    if (i < expression.length() - 1) {
                        startIdx = i + 4;
                    }
                }
            } else if (i == expression.length() - 1) {
                expressions.add(new Expression(expression.substring(startIdx)));
            }
        }

        return expressions;
    }
}
