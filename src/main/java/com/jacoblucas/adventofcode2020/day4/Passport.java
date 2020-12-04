package com.jacoblucas.adventofcode2020.day4;

import org.immutables.value.Value;

import java.util.List;
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
}
