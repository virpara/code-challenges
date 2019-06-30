package com.hackerrank.challenges;

import java.util.Arrays;
import java.util.Scanner;

public class SockMerchant {

    static int sockMerchant(int n, int[] ar) {
        int pairs = 0;
        
        Arrays.sort(ar);
        int prev = 0;
        int nums = 1;
        for (int i = 0; i < n; i++) {
            if (i == 0) prev = ar[i];
            else {
                if (prev == ar[i]) nums++;
                
                if (prev != ar[i] || i == n-1) {
                    prev = ar[i];
                    int possPairs = (int) Math.floor(nums / 2);
                    pairs += possPairs;
                    nums = 1;
                }
            }
        }
        
        return pairs;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        in.close();
        int result = sockMerchant(n, ar);
        System.out.println(result);
    }
}
