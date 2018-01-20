package com.hackerrank.thirtydaysofcode;

import java.util.Scanner;

public class Day29 {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int t = s.nextInt();
    
    for (int i = 0; i < t; i++) {
      int n = s.nextInt();
      int k = s.nextInt();
      
      int a = n;
      int b = n-1;
      
      int maxk = 0;
      
      while (a > 0) {
    	  
    	  while (b > 0) {
    		  int x = a & b;
    		  
    		  //System.out.println("a=" + a + " b=" + b + "x=" + x);
    		  if (x < k && maxk < x) {
    			  maxk = x;
    		  }
    		  b--;
    	  }
    	  
    	  a--;
    	  b = a-1;
      }
      
      System.out.println(maxk);
    }
    
    s.close();
  }

}
