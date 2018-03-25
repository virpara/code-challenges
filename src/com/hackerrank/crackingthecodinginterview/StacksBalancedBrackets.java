package com.hackerrank.crackingthecodinginterview;

import java.util.Scanner;
import java.util.Stack;

public class StacksBalancedBrackets {

    public static boolean isBalanced(String expression) {
        char[] c = expression.toCharArray();
        Stack<Character> openBrackets = new Stack<>();

        for (int i = 0; i < c.length; i++) {
            switch (c[i]) {
                case '[':
                case '{':
                case '(':
                    openBrackets.push(c[i]);
                    break;

                case ']':
                case '}':
                case ')':
                    char closing = getOpeningBracket(c[i]);
                    if (openBrackets.isEmpty() || !openBrackets.pop().equals(closing)) {
                        return false;
                    }
                    break;
            }
        }

        return openBrackets.isEmpty();

    }

    private static char getOpeningBracket(char c) {
        switch (c) {
            case ']':
                return '[';
            case '}':
                return '{';
            case ')':
                return '(';
        }

        return c;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println((isBalanced(expression)) ? "YES" : "NO");
        }
    }
}
