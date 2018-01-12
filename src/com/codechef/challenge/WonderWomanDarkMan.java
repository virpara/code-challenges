package com.codechef.challenge;

import java.util.Arrays;
import java.util.Scanner;

public class WonderWomanDarkMan {
  // todo
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    
    String[] num = new String[n];
    for (int i = 0; i < n; i++) {
      num[i] = sc.next();
    }
    
    Arrays.sort(num);
    
    for (int i = num.length-1; i >= 0; i--) {
      System.out.println(num[i]);
    }

  }

}
