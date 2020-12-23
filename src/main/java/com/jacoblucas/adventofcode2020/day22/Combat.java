package com.jacoblucas.adventofcode2020.day22;

import com.jacoblucas.adventofcode2020.utils.ImmutablePair;
import com.jacoblucas.adventofcode2020.utils.Pair;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class Combat {
    private final Player one;
    private final Player two;
    private final boolean isRecursive;
    private final Set<Pair<LinkedList<Integer>, LinkedList<Integer>>> history;

    public Combat(final Player one, final Player two, final boolean isRecursive) {
        this.one = one;
        this.two = two;
        this.isRecursive = isRecursive;
        this.history = new HashSet<>();
    }

    public void play() {
        final AtomicInteger roundCount = new AtomicInteger(0);
        while (!gameOver()) {
            playRound(roundCount);
        }

        System.out.println("== Post-game results ==");
        System.out.println("Player " + one.getId() + "'s deck: " + one.getDeck());
        System.out.println("Player " + two.getId() + "'s deck: " + two.getDeck());
        System.out.println("The winner is player " + getWinner().getId() + "!");
    }

    public boolean gameOver() {
        return (isRecursive && history.contains(ImmutablePair.of(one.getDeck(), two.getDeck()))) || one.getDeck().isEmpty() || two.getDeck().isEmpty();
    }

    public Player getWinner() {
        if (isRecursive && history.contains(ImmutablePair.of(one.getDeck(), two.getDeck()))) {
            return one;
        } else if (two.getDeck().isEmpty()) {
            return one;
        } else if (one.getDeck().isEmpty()) {
            return two;
        } else {
            return null;
        }
    }

    public void playRound(final AtomicInteger roundCount) {
        roundCount.getAndIncrement();
        System.out.println("-- Round " + roundCount.get() + " --");
        System.out.println(one);
        System.out.println(two);
        history.add(ImmutablePair.of(one.getDeck(), two.getDeck()));

        final int playerOneCard = one.play();
        System.out.println("Player " + one.getId() + " plays: " + playerOneCard);
        final int playerTwoCard = two.play();
        System.out.println("Player " + two.getId() + " plays: " + playerTwoCard);

        final Player winner;
        if (isRecursive && one.getDeck().size() >= playerOneCard && two.getDeck().size() >= playerTwoCard) {
            final Combat combat = new Combat(
                    new Player(1, new LinkedList<>(one.getDeck().subList(0, playerOneCard))),
                    new Player(2, new LinkedList<>(two.getDeck().subList(0, playerTwoCard))),
                    true);
            System.out.println("Playing a sub-game to determine the winner...\n");
            combat.play();
            winner = combat.getWinner();
            System.out.println("\n...anyway, back to the previous game");
        } else {
            winner = playerOneCard > playerTwoCard ? one : two;
        }

        System.out.println("Player " + winner.getId() + " wins round " + roundCount.get() + "!\n");
        if (isRecursive) {
            if (winner.getId() == 1) {
                one.getDeck().add(playerOneCard);
                one.getDeck().add(playerTwoCard);
            } else {
                two.getDeck().add(playerTwoCard);
                two.getDeck().add(playerOneCard);
            }
        } else {
            winner.getDeck().add(Math.max(playerOneCard, playerTwoCard));
            winner.getDeck().add(Math.min(playerOneCard, playerTwoCard));
        }
    }
}
