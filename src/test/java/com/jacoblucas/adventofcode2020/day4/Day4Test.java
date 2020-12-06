package com.jacoblucas.adventofcode2020.day4;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Day4Test {

    @Test
    public void testParse() {
        final List<List<String>> input = ImmutableList.of(
                ImmutableList.of(
                        "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd",
                        "byr:1937 iyr:2017 cid:147 hgt:183cm"),
                ImmutableList.of(
                        "iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884",
                        "hcl:#cfa07d byr:1929"),
                ImmutableList.of(
                        "hcl:#ae17e1 iyr:2013",
                        "eyr:2024",
                        "ecl:brn pid:760753108 byr:1931",
                        "hgt:179cm"),
                ImmutableList.of(
                        "hcl:#cfa07d eyr:2025 pid:166559648",
                        "iyr:2011 ecl:brn hgt:59in"));

        final List<Passport> passports = Day4.parse(input);
        assertThat(passports.size(), is(2));
    }
}
