package com.jacoblucas.adventofcode2020.day22;

import com.jacoblucas.adventofcode2020.utils.ImmutablePair;
import com.jacoblucas.adventofcode2020.utils.InputReader;
import com.jacoblucas.adventofcode2020.utils.Pair;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Day22 {
    public static void main(String[] args) throws IOException {
        final List<String> input = InputReader.read("day22-input.txt");

        Pair<Player, Player> players = toPlayers(input);
        Player one = players.getFirst();
        Player two = players.getSecond();

        play(one, two, false);

        players = toPlayers(input);
        one = players.getFirst();
        two = players.getSecond();

        play(one, two, true); // 1800-937-8997
    }

    private static Pair<Player, Player> toPlayers(final List<String> input) {
        for (int i=0; i<input.size(); i++) {
            if (input.get(i).isEmpty()) {
                final Player one = Player.parse(input.subList(0, i));
                final Player two = Player.parse(input.subList(i + 1, input.size()));
                return ImmutablePair.of(one, two);
            }
        }
        return ImmutablePair.of(new Player(1, new LinkedList<>()), new Player(2, new LinkedList<>()));
    }

    private static void play(final Player one, final Player two, final boolean isRecursive) {
        final Combat combat = new Combat(one, two, isRecursive);
        combat.play();

        final Player winner = combat.getWinner();
        System.out.println(winner.score());
    }
}
