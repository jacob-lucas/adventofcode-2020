package com.jacoblucas.adventofcode2020.day4;

import com.jacoblucas.adventofcode2020.utils.InputReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day4 {
    public static void main(String[] args) throws IOException {
        final List<String> lines = InputReader.read("day4-input.txt");

        final List<Passport> validPassports = parse(lines);

        System.out.println(validPassports.size());
    }

    public static List<Passport> parse(final List<String> input) {
        final List<Passport> validPassports = new ArrayList<>();
        int startIdx = 0;
        for (int i=0; i<input.size(); i++) {
            final String line = input.get(i);
            if (line.isEmpty()) {
                final List<String> inputLines = input.subList(startIdx, i);
                try {
                    System.out.println(inputLines);
                    final Passport passport = Passport.parse(inputLines);
                    validPassports.add(passport);
                } catch (final IllegalStateException iae) {
                    System.out.println(inputLines + " is invalid! " + iae.getMessage());
                } catch (final Exception e) {
                    e.printStackTrace();
                } finally {
                    startIdx = i + 1;
                }
            }
        }

        return validPassports;
    }
}
