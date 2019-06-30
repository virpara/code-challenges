package com.hackerrank.thirtydaysofcode;

import java.util.Scanner;

public class Day6 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int t = in.nextInt();
		in.nextLine(); // skip the blank char after the int
		
		String[] s = new String[t];
		
		for (int i = 0; i < t; i++) {
			s[i] = in.nextLine();
		}
		
		in.close();
		
		for (String str : s) {
			StringBuilder s1 = new StringBuilder();
			StringBuilder s2 = new StringBuilder();
			
			char[] ch = str.toCharArray();
			
			for (int i = 0; i < ch.length; i++) {
				if (i % 2 == 0) {
					s1.append(ch[i]);
				} else {
					s2.append(ch[i]);
				}
			}
			
			System.out.println(s1.append(" ").append(s2));
		}
	}
}
