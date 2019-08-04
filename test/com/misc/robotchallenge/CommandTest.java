package com.misc.robotchallenge;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class CommandTest {

    @Test
    void getTimes() {
        assertEquals(1, new Command("F1").getTimes());
        assertEquals(763, new Command("B763").getTimes());
        assertEquals(0, new Command("L0").getTimes());
        assertEquals(10, new Command("R10").getTimes());
        assertThrows(IllegalArgumentException.class, () -> new Command("F"));
    }

    @Test
    void getType() {
        assertEquals('F', new Command("F887656545").getType());
        assertEquals('R', new Command("R78").getType());
        assertEquals('L', new Command("L2").getType());
        assertEquals('B', new Command("B5").getType());
    }

    @Test
    void isValidCommand() {
        assertTrue(Command.isValidCommand("F1"));
        assertTrue(Command.isValidCommand("F11"));
        assertTrue(Command.isValidCommand("R2"));
        assertTrue(Command.isValidCommand("R22"));
        assertTrue(Command.isValidCommand("B2"));
        assertTrue(Command.isValidCommand("B22"));
        assertTrue(Command.isValidCommand("L2"));
        assertTrue(Command.isValidCommand("L22"));

        assertFalse(Command.isValidCommand("F"));
        assertFalse(Command.isValidCommand("12"));
        assertFalse(Command.isValidCommand("X22"));
        assertFalse(Command.isValidCommand("y22"));
        assertFalse(Command.isValidCommand("aa"));
        assertFalse(Command.isValidCommand("aa22"));
        assertFalse(Command.isValidCommand("22"));
        assertFalse(Command.isValidCommand("22F"));
        assertFalse(Command.isValidCommand("F-22"));
    }

    @Test
    void parseCommand() {
        assertNotNull(Command.parseCommand(""));
        assertIterableEquals(Command.parseCommand(""), Collections.emptyList());

        String[] coms = {"R1", "R93", "F2", "F34", "L3", "L10", "B4", "B43"};
        List<Command> l = Arrays.stream(coms).map(com -> new Command(com)).collect(Collectors.toList());
        assertEquals(8, l.size());

        assertNotNull(l.get(0));
        Command c = l.get(0);
        assertEquals('R', c.getType());
        assertEquals(1, c.getTimes());
    }
}