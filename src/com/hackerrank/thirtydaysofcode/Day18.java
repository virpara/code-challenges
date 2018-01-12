package com.hackerrank.thirtydaysofcode;

import java.util.Scanner;

public class Day18 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		scan.close();

		// Convert input String to an array of characters:
		char[] s = input.toCharArray();

		// Create a Solution object:
		Solution p = new Solution();

		// Enqueue/Push all chars to their respective data structures:
		for (char c : s) {
			p.pushCharacter(c);
			p.enqueueCharacter(c);
		}

		// Pop/Dequeue the chars at the head of both data structures and compare
		// them:
		boolean isPalindrome = true;
		for (int i = 0; i < s.length / 2; i++) {
			if (p.popCharacter() != p.dequeueCharacter()) {
				isPalindrome = false;
				break;
			}
		}

		// Finally, print whether string s is palindrome or not.
		System.out.println("The word, " + input + ", is " + ((!isPalindrome) ? "not a palindrome." : "a palindrome."));
	}
}

class Solution {
	char[] stack = new char[200];
	char[] queue = new char[200];

	int sidx = -1;
	int qstart = -1;
	int qend = -1;

	void pushCharacter(char ch) {
		if (sidx == stack.length - 1)
			return; // stack is full
		stack[++sidx] = ch;
	}

	char popCharacter() {
		if (sidx == -1)
			return ' '; // empty stack

		return stack[sidx--];
	}

	void enqueueCharacter(char ch) {
		if (qend == queue.length - 1)
			return; // queue is full
		queue[++qend] = ch;
	}

	char dequeueCharacter() {
		if (qstart == qend)
			return ' '; // empty queue

		return queue[++qstart];
	}
}
