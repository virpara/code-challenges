package diag2code.nodes;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Node start = XmlToGraphConverter.case3();

        Deque<Deque<Node>> paths = new LinkedList<>();

        Set<Node> visited = new HashSet<>();

        findAllPaths(paths, visited, start, new LinkedList<>());

        paths.forEach(System.out::println);
    }

    private static void findAllPaths(Deque<Deque<Node>> paths, Set<Node> visited, Node node, Deque<String> conditions) {
        if (node == null) return;

        visited.add(node);

        if (node instanceof Start) {
            Deque<Node> path = new LinkedList<>();
            path.addLast(node);

            paths.addLast(path);

            findAllPaths(paths, visited, node.next, conditions);
        } else if (node instanceof End) { // completed path.
            paths.getLast().addLast(node);
        } else if (node instanceof Condition) {
            paths.getLast().addLast(node);

            Condition con = (Condition) node;
            conditions.addLast(con.condition); // add the condition for the nodes on true path

            findAllPaths(paths, visited, con.trueNode, conditions);

            // create copy of the true path and remove elements from the copy until the conditional node,
            // because true and false both the paths share the elements until the condition node.
            // then start exploring the false path just like true path
            Deque<Node> newPath = new LinkedList<>(paths.getLast());
            paths.addLast(newPath);

            // remove the elements from end until the current conditional element
            Node curr = newPath.pollLast();
            while (!newPath.isEmpty() && curr != con) { // newPath cannot become empty condition node is in newPath
                curr = newPath.pollLast();
            }
            // condition node is removed by above loop. just add it for better readability of the false path
            newPath.addLast(con);

            // remove the last condition and change it to not condition, since the false path will be explored now
            conditions.removeLast();
            conditions.addLast(" not " + con.condition);

            findAllPaths(paths, visited, con.falseNode, conditions);
            conditions.removeLast(); // remove the condition when returning

        } else if (node instanceof Action) {
            paths.getLast().addLast(node);

            Action a = (Action) node;

            a.conditions.addLast(new LinkedList<>(conditions));

            if (a.conditions.size() > 1) System.out.println("Woah! merge node found: " + node);

            findAllPaths(paths, visited, a.next, conditions);
        }

        visited.remove(node);
    }

    private static class DiagramNode {
        private int v;
        private int weight;
        private DiagramNode next;

        DiagramNode(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }

        public DiagramNode getNext() {
            return next;
        }

        public void setNext(DiagramNode next) {
            this.next = next;
        }

        public int getV() {
            return v;
        }

        public int getWeight() {
            return weight;
        }
    }
}
