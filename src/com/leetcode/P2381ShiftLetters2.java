package com.leetcode;

public class P2381ShiftLetters2 {

    public static void main(String[] args) {
        String s = "dztz";
        int[][] shifts = {{0, 0, 0}, {1, 1, 1}};

        var o = new P2381ShiftLetters2();
        System.out.println(o.shiftingLetters(s, shifts));

//        System.out.println(o.shift('a', -2));
//        System.out.println(o.shift('z', 2));
    }

    public String shiftingLetters(String s, int[][] shifts) {
        StringBuilder sb = new StringBuilder();
        int[] prefix = new int[s.length() + 1];

        for (int[] shift : shifts) {
            int st = shift[0];
            int e = shift[1];
            int d = shift[2];

            if (d == 0) d = -1;

            prefix[st] += d;
            prefix[e + 1] -= d;
        }

        int currentShift = 0;
        for (int i = 0; i < s.length(); ++i) {
            currentShift += prefix[i];
            prefix[i] = currentShift;
        }

        StringBuilder result = new StringBuilder(s);
        for (int i = 0; i < s.length(); ++i) {
            int netShift = (prefix[i] % 26 + 26) % 26;
            result.setCharAt(i, (char) ('a' + (s.charAt(i) - 'a' + netShift) % 26));
        }

        return result.toString();
    }


    // TLE
    public String shiftingLettersSlow(String s, int[][] shifts) {
        StringBuilder sb = new StringBuilder();
        int[] actual = new int[s.length()];

        for (int i = 0; i < shifts.length; i++) {
            int[] sh = shifts[i];
            int start = sh[0];
            int end = sh[1];
            int dir = sh[2] == 0 ? -1 : 1;

            for (int j = start; j <= end; j++) {
                actual[j] = (actual[j] + dir) % 26;
            }
        }

        for (int i = 0; i < actual.length; i++) {
            sb.append(shift(s.charAt(i), actual[i]));
        }

        return sb.toString();
    }

    public char shift(char c, int times) {
        char x = (char) (c + (char) times);
        if (x > 'z') {
            x = (char) (x - 26);
        } else if (x < 'a') {
            x = (char) (x + 26);
        }

        return x;
    }
}
