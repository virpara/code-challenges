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

    static SinglyLinkedListNode reverseIterative(SinglyLinkedListNode head) {

        SinglyLinkedListNode cur = head;
        SinglyLinkedListNode prev = null;
        SinglyLinkedListNode next;

        while (cur != null) {
            next = cur.next;

            cur.next = prev; // change the pointer to prev node
            prev = cur;
            cur = next;
        }

        return prev;
    }

    private static final Scanner scanner = new Scanner(System.in);

    private static SinglyLinkedListNode remaining;

    public static void main(String[] args) {
        int tests = 1; //scanner.nextInt();

        for (int i = 0; i < tests; i++) {
            SinglyLinkedList list = new SinglyLinkedList();

//            int listCount = scanner.nextInt();
//
////            for (int j = 0; j < listCount; j++) {
////                int listItem = scanner.nextInt();
////
////                list.insertNode(listItem);
////            }

            int listCount = 6;
            list.insertNode(1);
            list.insertNode(2);
            list.insertNode(3);
            list.insertNode(4);
            list.insertNode(5);
            list.insertNode(6);

//            SinglyLinkedListNode reversedList = reverse(list.head);
//            printSinglyLinkedList(reversedList, " ");

//            SinglyLinkedListNode reversedList = reverseIterative(list.head);
            SinglyLinkedListNode reversedList = reverseBetweenIterative(list.head, 4, 5);
//            SinglyLinkedListNode reversedList = reverseBetweenRecursive(list.head, 2, 3);
            printSinglyLinkedList(reversedList, " ");

        }

        scanner.close();
    }

    private static SinglyLinkedListNode reverseBetweenRecursive(SinglyLinkedListNode head, int i, int j) {
        SinglyLinkedListNode preRev = skip(head, i);
        SinglyLinkedListNode rev = null;
        SinglyLinkedListNode iNode = preRev.next;

        if (iNode != null) {
            rev = reverseBetweenRecHelper(iNode, j);

        }
        preRev.next = rev;

        return head == null || head.data != i ? head : rev;
    }

    private static SinglyLinkedListNode reverseBetweenRecHelper(SinglyLinkedListNode iNode, int j) {
        if (iNode == null || iNode.next == null || iNode.data == j) {
            remaining = iNode.next;
            return iNode;
        }

        SinglyLinkedListNode rev = reverseBetweenRecHelper(iNode.next, j);

        if (rev.data != j) {
            rev.next.next = iNode;
            rev.next = null;
        }

        return rev;
    }

    private static SinglyLinkedListNode skip(SinglyLinkedListNode head, int upto) {
        SinglyLinkedListNode prev = head;
        while (head != null && head.data != upto) {
            prev = head;
            head = head.next;

        }

        return prev;
    }

    private static SinglyLinkedListNode reverseBetweenIterative(SinglyLinkedListNode head, int m, int n) {

        SinglyLinkedListNode preRev = null;
        SinglyLinkedListNode curr = head;

        int i = 1;
        while (i < m) {
            preRev = curr;
            curr = curr.next;
            i++;
        }

        SinglyLinkedListNode end = curr;
        SinglyLinkedListNode pre = null;

        while (i <= n) {
            SinglyLinkedListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
            i++;
        }

        end.next = curr;
        if (preRev != null) preRev.next = pre;

        return preRev == null ? pre : head;
    }


}
