package diag2code.nodes;

public class Condition extends Node {
    Node trueNode = null;
    Node falseNode = null;

    String condition;

    public Condition(String s) {
        condition = s;
    }

    @Override
    public String toString() {
        return "Condition{" +
                "condition='" + condition + '\'' +
                '}';
    }
}
