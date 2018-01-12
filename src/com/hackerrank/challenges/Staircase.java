package com.hackerrank.challenges;

import java.util.Scanner;

public class Staircase {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();
        
        for (int i = 0; i < n; i++) {
            for (int j = n - (i + 1); j > 0; j--) {
                System.out.print(" ");
            }
            
            for (int x = 0; x < i+1; x++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }
}
