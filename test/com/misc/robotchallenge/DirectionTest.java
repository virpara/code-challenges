package com.misc.robotchallenge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectionTest {

    @Test
    void turnRightXTimes() {
        assertEquals(Direction.EAST, Direction.NORTH.turnRightXTimes(1));
        assertEquals(Direction.SOUTH, Direction.NORTH.turnRightXTimes(2));
        assertEquals(Direction.WEST, Direction.NORTH.turnRightXTimes(3));
        assertEquals(Direction.NORTH, Direction.NORTH.turnRightXTimes(0));

        assertEquals(Direction.NORTH, Direction.NORTH.turnRightXTimes(4));
        assertEquals(Direction.EAST, Direction.EAST.turnRightXTimes(4));
        assertEquals(Direction.SOUTH, Direction.SOUTH.turnRightXTimes(4));
        assertEquals(Direction.WEST, Direction.WEST.turnRightXTimes(4));
        assertEquals(Direction.SOUTH, Direction.SOUTH.turnRightXTimes(8));
    }

    @Test
    void turnLeftXTimes() {
        assertEquals(Direction.NORTH, Direction.NORTH.turnLeftXTimes(0));
        assertEquals(Direction.WEST, Direction.NORTH.turnLeftXTimes(1));
        assertEquals(Direction.SOUTH, Direction.NORTH.turnLeftXTimes(2));
        assertEquals(Direction.EAST, Direction.NORTH.turnLeftXTimes(3));

        assertEquals(Direction.NORTH, Direction.NORTH.turnLeftXTimes(4));
        assertEquals(Direction.EAST, Direction.EAST.turnLeftXTimes(4));
        assertEquals(Direction.SOUTH, Direction.SOUTH.turnLeftXTimes(4));
        assertEquals(Direction.WEST, Direction.WEST.turnLeftXTimes(4));
        assertEquals(Direction.SOUTH, Direction.SOUTH.turnLeftXTimes(8));

        assertEquals(Direction.NORTH, Direction.EAST.turnLeftXTimes(1));
        assertEquals(Direction.EAST, Direction.SOUTH.turnLeftXTimes(1));
        assertEquals(Direction.SOUTH, Direction.WEST.turnLeftXTimes(1));
    }
}