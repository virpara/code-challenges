package com.hackerrank.thirtydaysofcode;

import java.util.Scanner;

public class Day5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();
        
        for (int i = 0; i < 10; i++) {
        	System.out.println(n + " x " + (i+1) + " = " + ( n*(i+1) ));
        }

    }
}
