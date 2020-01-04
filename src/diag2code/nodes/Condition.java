package diag2code.nodes;

public class Condition extends Node {
    Node truthy = null;
    Node falsy = null;

    String name;

    public Condition(String s) {
        name = s;
    }

}
