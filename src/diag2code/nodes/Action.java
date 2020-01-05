package diag2code.nodes;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Action extends Node {
    // action name
    String name;

    // conditions for this action
    Deque<Deque<String>> conditions = new LinkedList<>(); // if conditions.size > 1, it is merging node !

    public Action(String s) {
        this.name = s;
    }

    @Override
    public String toString() {
        return "Action{" +
                "name='" + name + '\'' +
                '}';
    }
}
