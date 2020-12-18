package com.jacoblucas.adventofcode2020.day18;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ExpressionTest {
    @Test
    public void splitNoSubExpressions() {
        final Expression expression = new Expression("1 + 2 * 3");
        assertThat(expression.split(), is(ImmutableList.of(expression)));
    }

    @Test
    public void splitWithSubExpressions() {
        final Expression expression = new Expression("1 + (2 * 3) + (4 * (5 + 6))");
        assertThat(expression.split().stream()
                .map(e -> e.expression)
                .collect(Collectors.toList()), is(ImmutableList.of("1", "2 * 3", "4 * (5 + 6)")));
    }

    @Test
    public void splitWithNestedSubExpressions() {
        final Expression expression = new Expression("1 + ((2 * 3) + (4 * (5 + 6)))");
        assertThat(expression.split().stream()
                .map(e -> e.expression)
                .collect(Collectors.toList()), is(ImmutableList.of("1", "(2 * 3) + (4 * (5 + 6))")));
    }

    @Test
    public void splitStartMultipleNests() {
        final Expression expression = new Expression("((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2");
        assertThat(expression.split().stream()
                .map(e -> e.expression)
                .collect(Collectors.toList()), is(ImmutableList.of("(2 + 4 * 9) * (6 + 9 * 8 + 6) + 6", "2 + 4 * 2")));
    }

    @Test
    public void splitWithTrailing() {
        final Expression expression = new Expression("(1 + 2) + 3 + 4 + 5");
        assertThat(expression.split().stream()
                .map(e -> e.expression)
                .collect(Collectors.toList()), is(ImmutableList.of("1 + 2", "3 + 4 + 5")));

    }

    @Test
    public void splitWithMiddle() {
        final Expression expression = new Expression("(1 + 2) + 3 + 6 + 7 + (4 + 5)");
        assertThat(expression.split().stream()
                .map(e -> e.expression)
                .collect(Collectors.toList()), is(ImmutableList.of("1 + 2", "3 + 6 + 7", "4 + 5")));

    }

    @Test
    public void splitWithLeading() {
        final Expression expression = new Expression("1 + 2 + 3 + (4 + 5)");
        assertThat(expression.split().stream()
                .map(e -> e.expression)
                .collect(Collectors.toList()), is(ImmutableList.of("1 + 2 + 3", "4 + 5")));

    }

    @Test
    public void emptyString() {
        assertThat(new Expression("").evaluate(), is(0L));
        assertThat(new Expression(null).evaluate(), is(0L));
    }

    @Test
    public void singleDigit() {
        assertThat(new Expression("5").evaluate(), is(5L));
    }

    @Test
    public void example1() {
        final String expr = "1 + 2 * 3 + 4 * 5 + 6";
        assertThat(new Expression(expr).evaluate(), is(71L));
    }

    @Test
    public void example2() {
        final String expr = "1 + (2 * 3) + (4 * (5 + 6))";
        assertThat(new Expression(expr).evaluate(), is(51L));
    }

    @Test
    public void example2a() {
        final String expr = "4 * (5 + 6)";
        assertThat(new Expression(expr).evaluate(), is(44L));
    }

    @Test
    public void example3() {
        final String expr = "2 * 3 + (4 * 5)";
        assertThat(new Expression(expr).evaluate(), is(26L));
    }

    @Test
    public void example4() {
        final String expr = "5 + (8 * 3 + 9 + 3 * 4 * 3)";
        assertThat(new Expression(expr).evaluate(), is(437L));
    }

    @Test
    public void example5() {
        final String expr = "5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))";
        assertThat(new Expression(expr).evaluate(), is(12240L));
    }

    @Test
    public void example6() {
        final String expr = "((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2";
        assertThat(new Expression(expr).evaluate(), is(13632L));
    }
}
