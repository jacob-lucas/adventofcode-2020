package com.jacoblucas.adventofcode2020.day12;

import static com.jacoblucas.adventofcode2020.day12.Action.EAST;
import static com.jacoblucas.adventofcode2020.day12.Action.FORWARD;
import static com.jacoblucas.adventofcode2020.day12.Action.LEFT;
import static com.jacoblucas.adventofcode2020.day12.Action.NORTH;
import static com.jacoblucas.adventofcode2020.day12.Action.RIGHT;
import static com.jacoblucas.adventofcode2020.day12.Action.SOUTH;
import static com.jacoblucas.adventofcode2020.day12.Action.WEST;

public class Ship {
    private char direction;
    private int x;
    private int y;

    public Ship() {
        this.direction = EAST.ch;
        this.x = 0;
        this.y = 0;
    }

    public char getDirection() {
        return direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move(final Instruction instruction) {
        final Action action = instruction.getAction();
        final int value = instruction.getValue();
        if (action == NORTH) {
            y = y + value;
        } else if (action == SOUTH) {
            y = y - value;
        } else if (action == WEST) {
            x = x - value;
        } else if (action == EAST) {
            x = x + value;
        } else if (action == FORWARD) {
            if (direction == NORTH.ch) {
                y = y + value;
            } else if (direction == SOUTH.ch) {
                y = y - value;
            } else if (direction == WEST.ch) {
                x = x - value;
            } else if (direction == EAST.ch) {
                x = x + value;
            }
        } else if (action == LEFT) {
            final int n = instruction.getValue() / 90;
            for (int i=0; i<n; i++) {
                final Action a = Action.of(direction);
                direction = a.getLeft().ch;
            }
        } else if (action == RIGHT) {
            final int n = instruction.getValue() / 90;
            for (int i=0; i<n; i++) {
                final Action a = Action.of(direction);
                direction = a.getRight().ch;
            }
        }
    }
}
