package com.jacoblucas.adventofcode2020.day4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Day4Test {

    @Test
    public void testParse() {
        final List<String> input = new ArrayList<>();
        input.add("ecl:gry pid:860033327 eyr:2020 hcl:#fffffd");
        input.add("byr:1937 iyr:2017 cid:147 hgt:183cm");
        input.add("");
        input.add("iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884");
        input.add("hcl:#cfa07d byr:1929");
        input.add("");
        input.add("hcl:#ae17e1 iyr:2013");
        input.add("eyr:2024");
        input.add("ecl:brn pid:760753108 byr:1931");
        input.add("hgt:179cm");
        input.add("");
        input.add("hcl:#cfa07d eyr:2025 pid:166559648");
        input.add("iyr:2011 ecl:brn hgt:59in");
        input.add("");

        final List<Passport> passports = Day4.parse(input);
        assertThat(passports.size(), is(2));
    }
}
