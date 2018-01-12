package com.hackerrank.challenges;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MigratoryBirds {

    static int migratoryBirds(int n, int[] ar) {
    	int common = 0;
        int[] types = new int[5];
        
        if (n == 1) common = ar[0];
        else if (n == 2) common = ar[0] <= ar[1] ? ar[0] : ar[1];
        else {
            for (int i = 0; i < n; i++) {
                int index = ar[i] - 1;
                types[index]++;
            }
            
            int[] temp = types.clone(); // to preserve the order of type occurrence
            
            Arrays.sort(types); // to find the max
            
            int i = 5-1;
            int max = types[i];
            
            while(types[i] == types[i-1] && i > 0) {
                max = types[i-1];
                i--;
            }
            
            for (int j = 0; j < 5; j++) {
            	if (temp[j] == max) {
                    common = j+1;
                    break; // made a mistake here
                } 
            }
            
        }
        
        return common;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        in.close();
        int result = migratoryBirds(n, ar);
        System.out.println(result);
    }
}
