package com.misc.robotchallenge;

public enum Direction {
    NORTH(0), EAST(1), SOUTH(2), WEST(3);

    private final int faceDir;

    Direction(int dir) {
        faceDir = dir;
    }

    public Direction turnRightXTimes(int times) {
        if(times < 0) throw new IllegalArgumentException("times should not be negative. Given: '" + times + "'");

        int dirValue = (faceDir + times) % 4;
        return Direction.values()[dirValue];
    }

    public Direction turnLeftXTimes(int times) {
        if(times < 0) throw new IllegalArgumentException("times should not be negative. Given: '" + times + "'");

        int dirValue = (faceDir - times) % 4;
        // convert negative index to proper positive index
        dirValue = dirValue < 0 ? dirValue + 4 : dirValue;

        return Direction.values()[dirValue];
    }
}
