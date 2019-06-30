package com.hackerrank.challenges;

import java.util.Scanner;

public class CatsAndAMouse {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int x = in.nextInt();
            int y = in.nextInt();
            int z = in.nextInt();
            
            int distA = Math.abs(z-x);
            int distB = Math.abs(z-y);
            
            if (distA == distB) System.out.println("Mouse C");
            else if (distA < distB) System.out.println("Cat A");
            else System.out.println("Cat B");
        }
        
        in.close();
        
    }
}
