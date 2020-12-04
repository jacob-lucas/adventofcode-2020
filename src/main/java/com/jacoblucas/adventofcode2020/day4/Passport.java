package com.jacoblucas.adventofcode2020.day4;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import org.immutables.value.Value;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Value.Immutable
public abstract class Passport {
    // byr
    public abstract int getBirthYear();

    // iyr
    public abstract int getIssueYear();

    // eyr
    public abstract int getExpirationYear();

    // hgt
    public abstract String getHeight();

    // hcl
    public abstract String getHairColour();

    // ecl
    public abstract String getEyeColour();

    // pid
    public abstract String getPassportId();

    // cid
    @Value.Default
    public String getCountryId() {
        return ""; // North Pole
    }

    public static Passport parse(final List<String> inputLines) {
        final String combined = inputLines.stream()
                .map(String::trim)
                .collect(Collectors.joining(" "));
        final String[] parts = combined.split(" ");

        final ImmutablePassport.Builder builder = ImmutablePassport.builder();

        for (final String part : parts) {
            final String[] kv = part.split(":");
            final String key = kv[0];
            if (key.equals("byr")) {
                builder.birthYear(Integer.parseInt(kv[1]));
            } else if (key.equals("iyr")) {
                builder.issueYear(Integer.parseInt(kv[1]));
            } else if (key.equals("eyr")) {
                builder.expirationYear(Integer.parseInt(kv[1]));
            } else if (key.equals("hgt")) {
                builder.height(kv[1]);
            } else if (key.equals("hcl")) {
                builder.hairColour(kv[1]);
            } else if (key.equals("ecl")) {
                builder.eyeColour(kv[1]);
            } else if (key.equals("pid")) {
                builder.passportId(kv[1]);
            } else if (key.equals("cid")) {
                builder.countryId(kv[1]);
            }
        }

        return builder.build();
    }

    public void validate() {
        Preconditions.checkArgument(getBirthYear() >= 1920 && getBirthYear() <= 2002, "byr (Birth Year) - four digits; at least 1920 and at most 2002.");
        Preconditions.checkArgument(getIssueYear() >= 2010 && getIssueYear() <= 2020, "iyr (Issue Year) - four digits; at least 2010 and at most 2020.");
        Preconditions.checkArgument(getExpirationYear() >= 2020 && getExpirationYear() <= 2030, "eyr (Expiration Year) - four digits; at least 2020 and at most 2030.");

        final String height = getHeight();
        boolean validHeight = false;
        if (height.contains("cm")) {
            final int measurement = Integer.parseInt(height.substring(0, height.indexOf("cm")));
            validHeight = measurement >= 150 && measurement <= 193;
        } else if (height.contains("in")) {
            final int measurement = Integer.parseInt(height.substring(0, height.indexOf("in")));
            validHeight = measurement >= 59 && measurement <= 76;
        }
        Preconditions.checkArgument(validHeight, "hgt (Height) - a number followed by either cm or in:\n" +
                "If cm, the number must be at least 150 and at most 193.\n" +
                "If in, the number must be at least 59 and at most 76.");

        final Pattern patternHcl = Pattern.compile("^#([0-9]|[a-f]){6}");
        Preconditions.checkArgument(patternHcl.matcher(getHairColour()).matches(), "hcl (Hair Color) - a # followed by exactly six characters 0-9 or a-f.");

        Preconditions.checkArgument(ImmutableList.of("amb", "blu", "brn", "gry", "grn", "hzl", "oth").contains(getEyeColour()), "ecl (Eye Color) - exactly one of: amb blu brn gry grn hzl oth.");

        final Pattern patternPid = Pattern.compile("^[0-9]{9}");
        Preconditions.checkArgument(patternPid.matcher(getPassportId()).matches(), "pid (Passport ID) - a nine-digit number, including leading zeroes.");
    }
}
