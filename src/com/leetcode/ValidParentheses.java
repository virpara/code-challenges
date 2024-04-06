package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class ValidParentheses {
    public static void main(String[] args) {
        ValidParentheses obj = new ValidParentheses();

        obj.isValid("{}{}{}");
        obj.isValid("[}");
    }

    public boolean isValid(String s) {

        char[] chars = s.toCharArray();

        Deque q = new LinkedList<Character>();

        for (char c : chars) {

            var ch = Character.valueOf(c);

            var first = q.peekFirst();

            switch (c) {
                case '{':
                case '[':
                case '(':
                    q.addFirst(ch);
                    break;

                case '}':
                    if (first != null && first.equals('{')) {
                        q.removeFirst();
                    } else {
                        q.addFirst(ch);
                    }
                    break;

                case ']':
                    if (first != null && first.equals('[')) {
                        q.removeFirst();
                    } else {
                        q.addFirst(ch);
                    }
                    break;

                case ')':
                    if (first != null && first.equals('(')) {
                        q.removeFirst();
                    } else {
                        q.addFirst(ch);
                    }
                    break;

                default:
                    //ignore
            }
        }

        if (!q.isEmpty()) return false;
        else return true;
    }
}
