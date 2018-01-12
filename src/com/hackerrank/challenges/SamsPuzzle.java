package com.hackerrank.challenges;

import java.util.Scanner;

public class SamsPuzzle {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] puzzle = new int[n][n];
        for(int puzzle_i=0; puzzle_i < n; puzzle_i++){
            for(int puzzle_j=0; puzzle_j < n; puzzle_j++){
                puzzle[puzzle_i][puzzle_j] = in.nextInt();
            }
        }
        in.close();
        
    	System.out.println("goodness=" + getGoodness(puzzle));
    	System.out.println("gMax=" + getMaxGoodness(new int[3][3]));
    	
    	//TODO find steps to achieve max goodness
    	
    }
    
    static int getGoodness(int[][] puzzle) {
    	int goodness = 0;
    	int n = puzzle.length;
    	
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				goodness += pairToCheck(puzzle, i, j);
			}
		}
    	
    	return goodness;
    }
    
    static int pairToCheck(int[][] puzzle, int i, int j) {
    	int n = puzzle.length;
    	int g = 0;
    	
    	int num = puzzle[i][j];
    	System.out.println("num=" + num);
    	for (int x = i; x < n; x++) {
    		
    		int num2 = puzzle[x][j];
    		if (x < i) {
    			// top cell ignore
    		} else if (x > i) {
    			// bottom cell
    			System.out.println("puzzle[x=" + x + "][j=" + j + "]=" + num2);
    			if (num < num2) g++;
    		}
    	}
    	
    	for (int x = j; x < n; x++) {
    		
    		int num2 = puzzle[i][x];
    		if(x < j) {
    			// left cell ignore
    		} else if (x > j) {
    			// right cell
    			System.out.println("puzzle[i=" + i + "][x=" + x + "]=" + num2);
    			if (num < num2) g++;
    		}
    	}
    	
    	System.out.println("i=" + i + "j=" + j + "g=" + g);
    	return g;
    }
    
    static int getMaxGoodness(int[][] puzzle) {
    	int n = puzzle.length;
    	int gmax = (int) Math.pow(n, 2) * (n - 1);
    	return gmax;
    }
}
