package com.misc.robotchallenge;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Command {

    /*
    F - Move forward
    B - Move backward
    R - turn right 90 degrees
    L - turn left 90 degrees
    */
    private static final Pattern commandPattern = Pattern.compile("^(F|B|R|L)(\\d+)$");

    private char type;
    private int times;

    public Command(String c) {
        if(!Command.isValidCommand(c)) throw new IllegalArgumentException("Invalid command");

        setTimes(c);
        setType(c);
    }

    public int getTimes() {
        return times;
    }

    public int getType() {
        return type;
    }
    public static boolean isValidCommand(String com) {
        Matcher m = commandPattern.matcher(com);
        return m.matches();
    }

    private void setTimes(String com) {
        Matcher m = commandPattern.matcher(com);
        if(m.find()) times = Integer.parseInt(m.group(2));
        else throw new IllegalArgumentException("Invalid command format");
    }

    private void setType(String com) {
        type = com.charAt(0);
    }

    public static List<Command> parseCommand(String command) {
        List<Command> commands = new LinkedList<>();

        String[] rawCommands = command.split(",");

        for(String c : rawCommands) {
            if(Command.isValidCommand(c)) {
                Command com = new Command(c);
                commands.add(com);
            } else {
                System.out.println("Command '" + c + "' is not a valid command.");
            }
        }

        return commands;
    }
}
