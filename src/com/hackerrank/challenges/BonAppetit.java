package com.hackerrank.challenges;

import java.util.Scanner;

public class BonAppetit {

    static void bonAppetit(int n, int k, int b, int[] ar) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (i != k) {
                sum += ar[i];
            }
        }
        sum /= 2; // cost of each
        
        if (sum < b) System.out.println(b-sum);
        else System.out.println("Bon Appetit");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int b = in.nextInt();
        in.close();
        bonAppetit(n, k, b, ar);
    }
}