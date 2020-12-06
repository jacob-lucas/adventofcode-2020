package com.jacoblucas.adventofcode2020.day6;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Day6Test {
    @Test
    public void testUniqueCharsEmptyList() {
        assertThat(Day6.uniqueQuestions(ImmutableList.of()), is(""));
    }

    @Test
    public void testUniqueCharsEmptyString() {
        assertThat(Day6.uniqueQuestions(ImmutableList.of("")), is(""));
    }

    @Test
    public void example1() {
        final List<String> questions = ImmutableList.of(
                "abcx",
                "abcy",
                "abcz");
        assertThat(Day6.uniqueQuestions(questions), is("abcxyz"));
    }

    @Test
    public void example2() {
        final List<String> questions = ImmutableList.of("abc");
        assertThat(Day6.uniqueQuestions(questions), is("abc"));
    }

    @Test
    public void example3() {
        final List<String> questions = ImmutableList.of("a", "b", "c");
        assertThat(Day6.uniqueQuestions(questions), is("abc"));
    }

    @Test
    public void example4() {
        final List<String> questions = ImmutableList.of("ab", "ac");
        assertThat(Day6.uniqueQuestions(questions), is("abc"));
    }

    @Test
    public void example5() {
        final List<String> questions = ImmutableList.of("a", "a", "a", "a");
        assertThat(Day6.uniqueQuestions(questions), is("a"));
    }

    @Test
    public void example6() {
        final List<String> questions = ImmutableList.of("b");
        assertThat(Day6.uniqueQuestions(questions), is("b"));
    }

    @Test
    public void example2Common() {
        final List<String> questions = ImmutableList.of("abc");
        assertThat(Day6.commonQuestions(questions), is("abc"));
    }

    @Test
    public void example3Common() {
        final List<String> questions = ImmutableList.of("a", "b", "c");
        assertThat(Day6.commonQuestions(questions), is(""));
    }

    @Test
    public void example4Common() {
        final List<String> questions = ImmutableList.of("ab", "ac");
        assertThat(Day6.commonQuestions(questions), is("a"));
    }

    @Test
    public void example5Common() {
        final List<String> questions = ImmutableList.of("a", "a", "a", "a");
        assertThat(Day6.commonQuestions(questions), is("a"));
    }

    @Test
    public void example6Common() {
        final List<String> questions = ImmutableList.of("b");
        assertThat(Day6.commonQuestions(questions), is("b"));
    }

    @Test
    public void testGetQuestionCountSumEmptyList() {
        final List<List<String>> groups = ImmutableList.of();
        assertThat(Day6.getQuestionCountSum(groups, Day6::uniqueQuestions), is(0));
    }

    @Test
    public void testGetUniqueQuestionCountSum() {
        final List<List<String>> groups = ImmutableList.of(
                ImmutableList.of("abc"),
                ImmutableList.of("a", "b", "c"),
                ImmutableList.of("ab", "ac"),
                ImmutableList.of("a", "a", "a", "a"),
                ImmutableList.of("b"));
        assertThat(Day6.getQuestionCountSum(groups, Day6::uniqueQuestions), is(11));
    }

    @Test
    public void testGetCommonQuestionCountSum() {
        final List<List<String>> groups = ImmutableList.of(
                ImmutableList.of("abc"),
                ImmutableList.of("a", "b", "c"),
                ImmutableList.of("ab", "ac"),
                ImmutableList.of("a", "a", "a", "a"),
                ImmutableList.of("b"));
        assertThat(Day6.getQuestionCountSum(groups, Day6::commonQuestions), is(6));
    }
}
