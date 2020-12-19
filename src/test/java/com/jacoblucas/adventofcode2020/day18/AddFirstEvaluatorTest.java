package com.jacoblucas.adventofcode2020.day18;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AddFirstEvaluatorTest {
    @Test
    public void example1() {
        final String expr = "1 + 2 * 3 + 4 * 5 + 6";
        assertThat(new AddFirstEvaluator().evaluate(expr), is(231L));
    }

    @Test
    public void example2() {
        final String expr = "1 + (2 * 3) + (4 * (5 + 6))";
        assertThat(new AddFirstEvaluator().evaluate(expr), is(51L));
    }

    @Test
    public void example3() {
        final String expr = "2 * 3 + (4 * 5)";
        assertThat(new AddFirstEvaluator().evaluate(expr), is(46L));
    }

    @Test
    public void example4() {
        final String expr = "5 + (8 * 3 + 9 + 3 * 4 * 3)";
        assertThat(new AddFirstEvaluator().evaluate(expr), is(1445L));
    }

    @Test
    public void example5() {
        final String expr = "5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))";
        assertThat(new AddFirstEvaluator().evaluate(expr), is(669060L));
    }

    @Test
    public void example6() {
        final String expr = "((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2";
        assertThat(new AddFirstEvaluator().evaluate(expr), is(23340L));
    }
}
