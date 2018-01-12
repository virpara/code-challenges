package com.hackerrank.challenges;

import java.util.Scanner;

public class GradingStudents {
  
  static int[] solve(int[] grades) {
    for (int i = 0; i < grades.length; i++)
      grades[i] = samsRounding(grades[i]);
    
    return grades;
  }
  private static int samsRounding(int grad) {
    if (grad < 38) return grad;
    
    int mod = grad % 5;
    if (mod > 2) {
      return grad + (5 - mod); 
    } else {
      return grad;
    }
    
  }
  
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] grades = new int[n];
    for(int grades_i=0; grades_i < n; grades_i++){
        grades[grades_i] = in.nextInt();
    }
    in.close();
    int[] result = solve(grades);
    for (int i = 0; i < result.length; i++) {
        System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
    }
    System.out.println("");
    

}
}
