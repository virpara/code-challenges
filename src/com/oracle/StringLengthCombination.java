package com.oracle;

public class StringLengthCombination {

    // todo: solve using recursion
    public static void main(String[] args) {
        String s = "abc";

//        permute(s.toCharArray(), 0);
        printCombination(s);
    }

    private static void permute(char[] str, int i) {
        System.out.println("i: " + i);
        if (i == str.length) {
            System.out.println(new String(str));
        }

        for (int j = i; j < str.length; j++) {
            swap(str, i, j + 1);
            permute(str, j + 1);
        }
    }

    public static void printCombination(String s) {

        char[] ch = s.toCharArray();
        //System.out.println(s);
        char[] word = ch.clone();
        for (int i = 0; i < ch.length; i++) {
            //System.out.println("i=" + i);
            System.out.println("init word=" + new String(word));

            int j = 0;
            for (; j < ch.length; j++) {
                if (j == i) continue;

                System.out.println("i=" + i + ", j=" + j + " before " + new String(word));
                swap(word, i, j);
                System.out.println(new String(word));
                swap(word, j, i);
            }

//			swap(word, i, j-1);
            System.out.println("end word=" + new String(word));
        }

    }


    public static void swap(char[] ch, int i, int j) {
        char c = ch[i];
        ch[i] = ch[j];
        ch[j] = c;
    }

}
