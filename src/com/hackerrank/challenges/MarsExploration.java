package com.hackerrank.challenges;

import java.util.Scanner;

public class MarsExploration {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.next();
        in.close();
        
        char[] ch = S.toCharArray();
        
        int distortion = 0;
        
        for (int i = 0; i < ch.length; i++) {
            int mod = i % 3;
            if ((mod == 0 || mod == 2 ) && ch[i] != 'S') distortion++;
            else if (mod == 1 && ch[i] != 'O') distortion++;
        }
        
        System.out.println(distortion);
    }
}