package com.jacoblucas.adventofcode2020.day15;

import com.google.common.collect.ImmutableList;

import java.io.IOException;
import java.util.List;

public class Day15 {
    public static void main(String[] args) throws IOException {
        final List<Integer> input = ImmutableList.of(1,17,0,10,18,11,6);
        final MemoryGame game = new MemoryGame(input);

        System.out.println(game.get(2020));
        System.out.println(game.get(30000000)); // Takes about 19 hrs to run :(
    }
}
