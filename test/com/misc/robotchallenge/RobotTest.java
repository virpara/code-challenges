package com.misc.robotchallenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RobotTest {
    private Robot testRobot;

    @BeforeEach
    void setUp() {
        testRobot = new Robot();
    }

    @Test
    void executeCommands() {
        List<Command> commands = Command.parseCommand("F1,R1,B2,L1,B3");
        testRobot.executeCommands(commands);
        assertEquals(4, testRobot.getMinDistance());
    }

    @Test
    void moveForward() {
        testRobot.executeCommands(Command.parseCommand("R1,F1"));
        testRobot.executeCommands(Command.parseCommand("R1,F1"));
        testRobot.executeCommands(Command.parseCommand("R1,F1"));
        testRobot.executeCommands(Command.parseCommand("R1,F1"));

        assertEquals(0, testRobot.getMinDistance());

        testRobot.executeCommands(Command.parseCommand("L1,F1"));
        testRobot.executeCommands(Command.parseCommand("L1,F1"));
        testRobot.executeCommands(Command.parseCommand("L1,F1"));
        testRobot.executeCommands(Command.parseCommand("L1,F1"));

        assertEquals(0, testRobot.getMinDistance());
    }

    @Test
    void moveBackward() {
        testRobot.executeCommands(Command.parseCommand("L1,B1"));
        testRobot.executeCommands(Command.parseCommand("L1,B1"));
        testRobot.executeCommands(Command.parseCommand("L1,B1"));
        testRobot.executeCommands(Command.parseCommand("L1,B1"));

        assertEquals(0, testRobot.getMinDistance());

        testRobot.executeCommands(Command.parseCommand("R1,B1"));
        testRobot.executeCommands(Command.parseCommand("R1,B1"));
        testRobot.executeCommands(Command.parseCommand("R1,B1"));
        testRobot.executeCommands(Command.parseCommand("R1,B1"));

        assertEquals(0, testRobot.getMinDistance());
    }
}