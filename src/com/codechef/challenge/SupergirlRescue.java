package com.codechef.challenge;

import java.util.Scanner;

public class SupergirlRescue {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    
    int[] num = new int[n];
    for (int i = 0; i < n; i++) {
      num[i] = sc.nextInt();
    }
    
    String ans = "Yes";
    if (n % 2 != 0) {
      //System.out.println("No");
      ans = "No";
    } else {
      for (int i = 0; i < n - 1; i += 2) {
        if (num[i] >= num[i+1]) {
          //System.out.println("No");
          ans = "No";
          break;
        }
        
      }
    }
    System.out.println(ans);
    sc.close();
  }

}
