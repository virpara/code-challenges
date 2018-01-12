package com.codechef.challenge;

import java.util.Scanner;

/**
 * https://www.codechef.com/BITF2017
 * @author Nividous01
 *
 */
public class ColorfulWalls {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    
    int[][] wall = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        wall[i][j] = sc.nextInt();
      }
    }
    sc.close();
    
    transform(wall);
    
    // print matrix
    System.out.println();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(wall[i][j] + " ");
      }
      System.out.println();
    }
    
  }

  private static void transform(int[][] wall) {
    int temp = 0;
    
    // transpose
    for (int i = 0; i < wall.length; i++) {
      for (int j = i; j < wall.length; j++) {
//        System.out.println(i + " " + j + " -> " + j + " " + i);
        temp = wall[i][j];
        wall[i][j] = wall[j][i];
        wall[j][i] = temp;
      }
    }
    
    // reverse rows (clockwise 90 degrees) and reverse column gives anti-clockwise 90 degrees
    for (int i = 0; i < wall.length; i++) {
      for (int j = 0, x = wall.length - 1; j < x; j++, x--) {
        temp = wall[i][j];
        wall[i][j] = wall[i][x];
        wall[i][x] = temp;
      }
    }
  }

}
