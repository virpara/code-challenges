package diag2code.nodes;

import java.util.*;

public class Main {
    static Stack<Node> stack = new Stack<>();
    static Map<Node, Stack<Node>> trueNodes = new HashMap<>();
    static Map<Node, Stack<Node>> falseNodes = new HashMap<>();

    static Set<Node> visited = new HashSet<>();

    static boolean isVisited(Node n) {
        return visited.contains(n);
    }

    public static void main(String[] args) {
        // case 1
//        Start s = new Start();
//
//        Action a1 = new Action("Log1");
//        s.next = a1;
//
//        Action a2 = new Action("false condition");
//        a1.next = a2;
//
//        Action a3 = new Action("common");
//        a2.next = a3;
//
//        End e = new End();
//        a3.next = e;

        // case 2
        Start s = new Start();

        Action a = new Action("Log1");
        s.next = a;

        Condition c = new Condition("Condition1");
        a.next = c;

        Action f1 = new Action("false condition");
        c.falseNode = f1;

        Action f2 = new Action("false condition2");
        f1.next = f2;

        Action t1 = new Action("true condition");
        c.trueNode = t1;

        Action tf = new Action("common");

        t1.next = tf;
        f2.next = tf;

        End e = new End();
        tf.next = e;

        traversePrepare(s, stack);
        System.out.println("case traversal ends");
        traversePrint(stack);
    }

    static void traversePrepare(Node node, Stack s) {
        if (node == null) return;

        if (node instanceof End) {
            s.add(node);
            return;
        } else if (node instanceof Start) {
            // start new stack for nested process.
            traversePrepare(node.next, s);
        } else if (node instanceof Action) {
            s.add(node);
            traversePrepare(node.next, s);
        } else if (node instanceof Condition) {
            s.add(node);
            Condition c = (Condition) node;

            if (c.trueNode != null) trueNodes.put(c, new Stack<>());
            if (c.falseNode != null) falseNodes.put(c, new Stack<>());

            if (trueNodes.containsKey(c)) traversePrepare(c.trueNode, trueNodes.get(c));
            if (falseNodes.containsKey(c)) traversePrepare(c.falseNode, falseNodes.get(c));

        }
    }

    static void traversePrint(Stack s) {
        if (s == null) return;

        while (!s.empty()) {
            Node n = (Node) s.pop();

            if (n instanceof End) {
                System.out.println("End isVisited: " + isVisited(n));
                visited.add(n);
            } else if (n instanceof Action) {
                System.out.println(((Action) n).name + " isVisited: " + isVisited(n));
                visited.add(n);
            } else if (n instanceof Condition) {
                System.out.println(((Condition) n).condition + " isVisited: " + isVisited(n));
                visited.add(n);

                if (trueNodes.containsKey(n)) {
                    traversePrint(trueNodes.get(n));
                    trueNodes.remove(n);
                }

                if (falseNodes.containsKey(n)) {
                    traversePrint(falseNodes.get(n));
                    falseNodes.remove(n);
                }
            }

        }

    }
}
