package com.jacoblucas.adventofcode2020.day4;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PassportTest {
    @Test
    public void example1() {
        final List<String> input = ImmutableList.of(
                "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd",
                "byr:1937 iyr:2017 cid:147 hgt:183cm");

        final Passport passport = Passport.parse(input);
        assertThat(passport, is(ImmutablePassport.builder()
                .eyeColour("gry")
                .passportId("860033327")
                .expirationYear(2020)
                .hairColour("#fffffd")
                .birthYear(1937)
                .issueYear(2017)
                .countryId("147")
                .height("183cm")
                .build()));
    }

    @Test(expected = IllegalStateException.class)
    public void example2() {
        final List<String> input = ImmutableList.of(
                "iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884",
                "hcl:#cfa07d byr:1929");

        Passport.parse(input);
    }

    @Test
    public void example3() {
        final List<String> input = ImmutableList.of(
                "hcl:#ae17e1 iyr:2013",
                "eyr:2024",
                "ecl:brn pid:760753108 byr:1931",
                "hgt:179cm");

        final Passport passport = Passport.parse(input);
        assertThat(passport, is(ImmutablePassport.builder()
                .eyeColour("brn")
                .passportId("760753108")
                .expirationYear(2024)
                .hairColour("#ae17e1")
                .birthYear(1931)
                .issueYear(2013)
                .height("179cm")
                .build()));
    }

    @Test(expected = IllegalStateException.class)
    public void example4() {
        final List<String> input = ImmutableList.of(
                "hcl:#cfa07d eyr:2025 pid:166559648",
                "iyr:2011 ecl:brn hgt:59in");

        Passport.parse(input);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidBirthYear() {
        final Passport passport = Passport.parse(ImmutableList.of(
                "eyr:1972 cid:100",
                "hcl:#18171d ecl:amb hgt:170 pid:186cm iyr:2018 byr:1926"));
        passport.validate();
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidExpirationYear() {
        final Passport passport = Passport.parse(ImmutableList.of(
                "iyr:2019",
                "hcl:#602927 eyr:1967 hgt:170cm",
                "ecl:grn pid:012533040 byr:1946"));
        passport.validate();
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidHairColour() {
        final Passport passport = Passport.parse(ImmutableList.of(
                "hcl:dab227 iyr:2012",
                "ecl:brn hgt:182cm pid:021572410 eyr:2020 byr:1992 cid:277"));
        passport.validate();
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidHeight() {
        final Passport passport = Passport.parse(ImmutableList.of(
                "hgt:49in ecl:blu",
                "eyr:2030 hcl:#74454a iyr:2020",
                "pid:3556412378 byr:2001"));
        passport.validate();
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidPassportId() {
        final Passport passport = Passport.parse(ImmutableList.of(
                "hgt:69in ecl:blu",
                "eyr:2030 hcl:#74454a iyr:2020",
                "pid:abc byr:2001"));
        passport.validate();
    }
}
