package com.hackerrank.challenges;

import java.util.Scanner;

public class HurdleRace {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] height = new int[n];
        for(int height_i=0; height_i < n; height_i++){
            height[height_i] = in.nextInt();
        }
        
        in.close();
        
        int maxh = 0, temph;
        for (int i = 0; i < n; i++) {
            temph = height[i];
            if (temph > maxh) maxh = temph;
        }
        
        int magicb = 0;
        if (k < maxh) magicb = maxh - k;
        
        System.out.println(magicb);
    }
}
