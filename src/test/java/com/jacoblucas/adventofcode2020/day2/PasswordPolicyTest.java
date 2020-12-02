package com.jacoblucas.adventofcode2020.day2;

import com.jacoblucas.adventofcode2020.utils.Pair;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PasswordPolicyTest {
    @Test
    public void testExamples() {
        final String line1 = "1-3 a: abcde";
        verifyV1(line1, true);
        final String line2 = "1-3 b: cdefg";
        verifyV1(line2, false);
        final String line3 = "2-9 c: ccccccccc";
        verifyV1(line3, true);
    }

    @Test
    public void testExamplesV2() {
        final String line1 = "1-3 a: abcde";
        verifyV2(line1, true);
        final String line2 = "1-3 b: cdefg";
        verifyV2(line2, false);
        final String line3 = "2-9 c: ccccccccc";
        verifyV2(line3, false);
    }

    public void verifyV1(final String line, final boolean expected) {
        final Pair<PasswordPolicy, String> pair = Day2.parse(line);
        final PasswordPolicy policy = pair.getFirst();
        final String password = pair.getSecond();
        assertThat(new PasswordValidatorV1().isValid(password, policy), is(expected));
    }

    public void verifyV2(final String line, final boolean expected) {
        final Pair<PasswordPolicy, String> pair = Day2.parse(line);
        final PasswordPolicy policy = pair.getFirst();
        final String password = pair.getSecond();
        assertThat(new PasswordValidatorV2().isValid(password, policy), is(expected));
    }
}
