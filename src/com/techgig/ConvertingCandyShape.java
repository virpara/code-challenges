package com.techgig;

import java.util.Scanner;

/*
Mphasis challenge
 Converting the candies shape (100 Marks)
An Annual learning competition was organised by a college in its various branches. Various students enrolled their name in the competition for their participation. Children are assigned a task on the spot about a puzzle which they have to solve in a very limited duration of time. They have been given a right isosceles triangle made of n > 0 lines containing 1, 3, . . . , 2n âˆ’ 1 identical candies, respectively. They have to find out the minimum number of candies that will be needed to move these candies to create a square made up of all the candies given in the triangle. The student who solves this puzzle first will be awarded first and so on..

You have to return the minimum number of candies that is needed to move to convert the isosceles triangle into square made up of all the candies.

Scored 100/100
 */
public class ConvertingCandyShape {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        int oneSideColDotsMax = n/2;

        // one side dot count = ( (n/2) * ((n/2)+1 ) / 2
        int totalColDots = (oneSideColDotsMax * (oneSideColDotsMax + 1));

        // for n % 2 == 0, we don't need to change the number of dots same as oneSideCols
        if(n % 2 == 0 && n != 0) totalColDots -= oneSideColDotsMax;

        System.out.println(totalColDots);
    }
}
