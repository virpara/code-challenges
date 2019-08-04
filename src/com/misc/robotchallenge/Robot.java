package com.misc.robotchallenge;

import java.util.List;

public class Robot {

    // current position
    private int x = 0;
    private int y = 0;

    private Direction face = Direction.NORTH;

    public void executeCommands(List<Command> commands) {
        for(Command com : commands) {
            int times = com.getTimes();
//            System.out.println(String.format("dir: %c, times: %s", com.getType(), times));
            switch (com.getType()) {
                case 'F':
                    moveForward(times);
                    break;
                case 'B':
                    moveBackward(times);
                    break;
                case 'R':
                    turnRight(times);
                    break;
                case 'L':
                    turnLeft(times);
                    break;
                default:
                    // should not reach here
            }
        }
    }

    public void turnLeft(int times) {
        face = face.turnLeftXTimes(times);
    }

    public void turnRight(int times) {
        face = face.turnRightXTimes(times);
    }

    public void moveForward(int times) {
        if(face == Direction.NORTH) y += times;
        else if(face == Direction.EAST) x += times;
        else if(face == Direction.SOUTH) y -= times;
        else if(face == Direction.WEST) x -= times;
    }

    public void moveBackward(int times) {
        if(face == Direction.NORTH) y -= times;
        else if(face == Direction.EAST) x -= times;
        else if(face == Direction.SOUTH) y += times;
        else if(face == Direction.WEST) x += times;
    }

    public int getMinDistance() {
//        System.out.println(String.format("x: %s, y: %s", x, y));
        return Math.abs(x) + Math.abs(y);
    }
}
