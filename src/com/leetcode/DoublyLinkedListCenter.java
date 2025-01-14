package com.leetcode;

class DoublyLinkedListCenter {

    public static void main(String[] args) {

        Node n1 = new Node(5);

        Node n2 = new Node(10);
        n2.setPrev(n1);
        n1.setNext(n2);

        Node n3 = new Node(15);
        n3.setPrev(n2);
        n2.setNext(n3);

        Node n4 = new Node(20);
        n4.setPrev(n3);
        n3.setNext(n4);

        Node n5 = new Node(25);
        n5.setPrev(n4);
        n4.setNext(n5);

        int center = findCenter(n1);
        System.out.println(center);
    }

    public static int findCenter(Node start) {
        if (start == null) return -1;

        Node p1 = start;
        Node p2 = start;
        while (p2 != null && p2.next != null) {
            p2 = p2.next.next;
            p1 = p1.next;
        }

        return p1.getValue();
    }

    static class Node {
        private Node next;
        private Node prev;
        private int val;

        Node(int val) {
            this.val = val;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public int getValue() {
            return val;
        }
    }


}