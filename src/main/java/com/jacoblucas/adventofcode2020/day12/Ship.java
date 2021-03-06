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
            y += value;
        } else if (action == SOUTH) {
            y -= value;
        } else if (action == WEST) {
            x -= value;
        } else if (action == EAST) {
            x += value;
        } else if (action == FORWARD) {
            if (direction == NORTH.ch) {
                y += value;
            } else if (direction == SOUTH.ch) {
                y -= value;
            } else if (direction == WEST.ch) {
                x -= value;
            } else if (direction == EAST.ch) {
                x += value;
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

    public void move(final Instruction instruction, final Waypoint waypoint) {
        final Action action = instruction.getAction();
        final int value = instruction.getValue();
        if (action == FORWARD) {
            x += value * waypoint.getX();
            y += value * waypoint.getY();
        } else {
            waypoint.move(instruction);
        }
    }
}
