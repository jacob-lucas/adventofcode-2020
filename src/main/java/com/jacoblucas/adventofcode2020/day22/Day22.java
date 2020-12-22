package com.jacoblucas.adventofcode2020.day22;

import com.jacoblucas.adventofcode2020.utils.InputReader;

import java.io.IOException;
import java.util.List;

public class Day22 {
    public static void main(String[] args) throws IOException {
        final List<String> input = InputReader.read("day22-input.txt");

        Player one = null;
        Player two = null;
        for (int i=0; i<input.size(); i++) {
            if (input.get(i).isEmpty()) {
                one = Player.parse(input.subList(0, i));
                two = Player.parse(input.subList(i + 1, input.size()));
                break;
            }
        }

        final Combat combat = new Combat(one, two);
        final Player winner = combat.play();
        System.out.println(winner.score());
    }
}
