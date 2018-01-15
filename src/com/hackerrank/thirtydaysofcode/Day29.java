package com.hackerrank.thirtydaysofcode;

import java.util.Scanner;

public class Day29 {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int t = s.nextInt();
    
    for (int i = 0; i < t; i++) {
      int n = s.nextInt();
      int k = s.nextInt();
      
      double pow = 1;
      int x = (int) 1;
      int y = (int) 1 << 1;
      while (y <= n && (x&y) < k) {
        System.out.println("pow=" + pow + " x=" + Integer.toBinaryString(x) 
          + " y=" + Integer.toBinaryString(y) + " x&y=" + (x&y));
//        pow++;
        x = (int) x + (x << 1);
        y = (int) y + (y << 1);
      }
      System.out.println("pow=" + pow + " x=" + x + " y=" + y + " x&y=" + (x&y));
      
      System.out.println( (x >> 1 ) & (y >> 1) );
    }
    
    s.close();
  }

}
