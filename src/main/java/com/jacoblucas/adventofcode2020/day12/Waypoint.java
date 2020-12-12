package com.jacoblucas.adventofcode2020.day12;

import static com.jacoblucas.adventofcode2020.day12.Action.EAST;
import static com.jacoblucas.adventofcode2020.day12.Action.LEFT;
import static com.jacoblucas.adventofcode2020.day12.Action.NORTH;
import static com.jacoblucas.adventofcode2020.day12.Action.RIGHT;
import static com.jacoblucas.adventofcode2020.day12.Action.SOUTH;
import static com.jacoblucas.adventofcode2020.day12.Action.WEST;

public class Waypoint {
    private int x, y;

    public Waypoint(final int x, final int y) {
        this.x = x;
        this.y = y;
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
        } else if (action == LEFT) {
            // switch x and y and make y negative
            final int n = instruction.getValue() / 90;
            for (int i=0; i<n; i++) {
                final int oldX = x;
                final int oldY = y;
                x = oldY * -1;
                y = oldX;
            }
        } else if (action == RIGHT) {
            // switch x and y and make x negative
            final int n = instruction.getValue() / 90;
            for (int i=0; i<n; i++) {
                final int oldX = x;
                final int oldY = y;
                x = oldY;
                y = oldX * -1;
            }
        }
    }
}
