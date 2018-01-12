package com.codechef.jan18;

import java.io.InputStream;
import java.util.Scanner;

public class KConcatenation {

  public static void main(String[] args) {
    generateTests();
    
    Scanner s = new Scanner(System.in);
    int t = s.nextInt();
    for (int i = 0; i < t; i++) {
      int n = s.nextInt();
      int k = s.nextInt();

      int[] num = new int[n];
      for (int j = 0; j < n; j++) {
        num[j] = s.nextInt();
      }

      int sum = 0;
      int maxSum = 0;
      boolean isNeg = false;

      int sumStart = 0;
      int lastNegIdx = 0;
        
      for (int j = 0; j < n; j++) {
        if (num[j] > 0) {
          sum += num[j];
        } else if (num[j] < 0) {
          maxSum = sum > maxSum ? sum : maxSum;

          // store sum before first negative num
          if (!isNeg) {
            sumStart = sum;
            lastNegIdx = j;
          }

          sum = 0;
          isNeg = true;
        }
      }
          
      // if last digit is positive
      maxSum = sum > maxSum ? sum : maxSum;

      if (lastNegIdx > 0) {
        for (int j = lastNegIdx + 1; j < n; j++) {
          sumStart += num[j];
        }

        maxSum = sumStart > maxSum ? sumStart : maxSum;
      }



      if (!isNeg) {
        maxSum = maxSum > 0 ? maxSum * k : sum * k;
      } else {
        maxSum = maxSum > 0 ? maxSum : sum;
      }


      System.out.println(maxSum);
        
    }
    
  }

  private static void generateTests() {
    InputStream is = System.in;
    
    // TODO
  }

}
