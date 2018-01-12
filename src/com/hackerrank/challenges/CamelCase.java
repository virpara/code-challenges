package com.hackerrank.challenges;

import java.util.Scanner;

public class CamelCase {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        in.close();
        
        int words = 0;
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (i == 0) words++;
            else {
                if (ch[i] >= 65 && ch[i] <= 90) words++;
            }
        }
        
        System.out.println(words);
    }
}
