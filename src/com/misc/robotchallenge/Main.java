package com.misc.robotchallenge;

import java.util.List;

public class Main {

    public static void main(String[] args) {
//        String c = "F1,R1,B2,L1,B3";

        if(args.length < 1) {
            System.out.println("Please provide comma separated string of robot commands.");
            System.exit(1);
        }

        List<Command> commands = Command.parseCommand(args[0]);

        Robot r = new Robot();
        r.executeCommands(commands);

        System.out.println(r.getMinDistance());
    }
}

