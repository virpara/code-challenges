package com.hackerrank.thirtydaysofcode;

import java.util.HashSet;
import java.util.Scanner;

public class Day24 {

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}

	}
	// implemented
	public static Node removeDuplicates(Node head) {
		HashSet<Integer> s = new HashSet<Integer>();

		Node n = head;
		Node prev = null;

		while (n != null) {
			if (s.contains(n.data)) {
				prev.next = n.next;
			} else {
				s.add(n.data);
				prev = n;
			}

			n = n.next;
		}

		return head;
	}

	public static Node insert(Node head, int data) {
		Node p = new Node(data);
		if (head == null)
			head = p;
		else if (head.next == null)
			head.next = p;
		else {
			Node start = head;
			while (start.next != null)
				start = start.next;
			start.next = p;

		}
		return head;
	}

	public static void display(Node head) {
		Node start = head;
		while (start != null) {
			System.out.print(start.data + " ");
			start = start.next;
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Node head = null;
		int T = sc.nextInt();
		while (T-- > 0) {
			int ele = sc.nextInt();
			head = insert(head, ele);
		}
		sc.close();
		head = removeDuplicates(head);
		display(head);

	}
}
