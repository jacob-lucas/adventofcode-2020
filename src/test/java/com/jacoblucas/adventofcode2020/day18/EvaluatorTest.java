package com.jacoblucas.adventofcode2020.day18;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class EvaluatorTest {
    private final InOrderEvaluator inOrderEvaluator = new InOrderEvaluator();
    
    @Test
    public void splitNoSubExpressions() {
        final String expression = "1 + 2 * 3";
        assertThat(inOrderEvaluator.split(expression), is(ImmutableList.of(expression)));
    }

    @Test
    public void splitWithSubExpressions() {
        final String expression = "1 + (2 * 3) + (4 * (5 + 6))";
        assertThat(inOrderEvaluator.split(expression), is(ImmutableList.of("1", "2 * 3", "4 * (5 + 6)")));
    }

    @Test
    public void splitWithNestedSubExpressions() {
        final String expression = "1 + ((2 * 3) + (4 * (5 + 6)))";
        assertThat(inOrderEvaluator.split(expression), is(ImmutableList.of("1", "(2 * 3) + (4 * (5 + 6))")));
    }

    @Test
    public void splitStartMultipleNests() {
        final String expression = "((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2";
        assertThat(inOrderEvaluator.split(expression), is(ImmutableList.of("(2 + 4 * 9) * (6 + 9 * 8 + 6) + 6", "2 + 4 * 2")));
    }

    @Test
    public void splitWithTrailing() {
        final String expression = "(1 + 2) + 3 + 4 + 5";
        assertThat(inOrderEvaluator.split(expression), is(ImmutableList.of("1 + 2", "3 + 4 + 5")));

    }

    @Test
    public void splitWithMiddle() {
        final String expression = "(1 + 2) + 3 + 6 + 7 + (4 + 5)";
        assertThat(inOrderEvaluator.split(expression), is(ImmutableList.of("1 + 2", "3 + 6 + 7", "4 + 5")));

    }

    @Test
    public void splitWithLeading() {
        final String expression = "1 + 2 + 3 + (4 + 5)";
        assertThat(inOrderEvaluator.split(expression), is(ImmutableList.of("1 + 2 + 3", "4 + 5")));
    }
}
