package com.jacoblucas.adventofcode2020.day22;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Player {
    private int id;
    private LinkedList<Integer> deck;

    public Player(final int id, final LinkedList<Integer> deck) {
        this.id = id;
        this.deck = deck;
    }

    public static Player parse(final List<String> input) {
        final int id = Integer.parseInt(input.get(0).split(" ")[1].split(":")[0]);
        final LinkedList<Integer> deck = new LinkedList<>();
        IntStream.range(1, input.size())
                .forEach(i -> deck.add(Integer.parseInt(input.get(i))));
        return new Player(id, deck);
    }

    public int getId() {
        return id;
    }

    public LinkedList<Integer> getDeck() {
        return deck;
    }

    @Override
    public String toString() {
        return String.format("Player %d's deck: %s", id, deck);
    }

    public Integer play() {
        return deck.poll();
    }

    public long score() {
        long score = 0;
        final int n = deck.size();
        for (int i=0; i<deck.size(); i++) {
            score += (long) deck.get(i) * (n-i);
        }
        return score;
    }
}
