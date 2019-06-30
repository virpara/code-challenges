package com.hackerrank.datastructure;

import java.util.Scanner;

public class ReverseSinglyLinkedList {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep) {
        while (node != null) {
            System.out.print(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                System.out.print(sep);
            }
        }
    }

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
        if(head == null || head.next == null) {
            //System.out.print("NULL");
            return head;
        }


        SinglyLinkedListNode remaining = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return remaining;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int tests = scanner.nextInt();

        for (int i = 0; i < tests; i++) {
            SinglyLinkedList list = new SinglyLinkedList();

            int listCount = scanner.nextInt();

            for (int j = 0; j < listCount; j++) {
                int listItem = scanner.nextInt();

                list.insertNode(listItem);
            }

            SinglyLinkedListNode reversedList = reverse(list.head);

            printSinglyLinkedList(reversedList, " ");
        }

        scanner.close();
    }
}
