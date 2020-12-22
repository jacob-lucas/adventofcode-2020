package com.jacoblucas.adventofcode2020.day22;

import java.util.concurrent.atomic.AtomicInteger;

public class Combat {
    private final Player one;
    private final Player two;

    public Combat(final Player one, final Player two) {
        this.one = one;
        this.two = two;
    }

    public Player play() {
        final AtomicInteger roundCount = new AtomicInteger(0);
        while (!gameOver()) {
            playRound(roundCount);
        }

        System.out.println("== Post-game results ==");
        System.out.println("Player " + one.getId() + "'s deck: " + one.getDeck());
        System.out.println("Player " + two.getId() + "'s deck: " + two.getDeck());
        return one.getDeck().isEmpty() ? two : one;
    }

    public boolean gameOver() {
        return one.getDeck().isEmpty() || two.getDeck().isEmpty();
    }

    public void playRound(final AtomicInteger roundCount) {
        roundCount.getAndIncrement();
        System.out.println("-- Round " + roundCount.get() + " --");
        System.out.println(one);
        System.out.println(two);

        final int playerOneCard = one.play();
        System.out.println("Player " + one.getId() + " plays: " + playerOneCard);
        final int playerTwoCard = two.play();
        System.out.println("Player " + two.getId() + " plays: " + playerTwoCard);

        final Player winner = playerOneCard > playerTwoCard ? one : two;
        System.out.println("Player " + winner.getId() + " wins the round!\n");
        winner.getDeck().add(Math.max(playerOneCard, playerTwoCard));
        winner.getDeck().add(Math.min(playerOneCard, playerTwoCard));
    }
}
