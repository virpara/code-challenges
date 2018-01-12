package com.oracle;

public class WordAnagrams {
	// TODO
	static void anagram(char[] chs, int j) {
		if (j == chs.length) return;
		
		
		anagram(chs, j);
	}
	
	public static void main(String[] args) {
		String word = "abcde";
		
		char[] chs = word.toCharArray();
		int j = 0;
		
		for (int i = chs.length-1; i >= 0; i--) {
			//anagram(chs, i); // should print all anagrams starting with a, c and b
			System.out.println(new String(chs));
			swap(chs, 0, i);
		}
		
		
		
		
//		int possibleAnagrams = fact(chs.length);
//		
		//doesn't work for string length > 3 :(
//		int x = 2;
//		int y = 1;
//		for (int i = 0; i < possibleAnagrams; i++) {
//			
//			System.out.print("i=" + i + " x=" + x + " y=" + y + " ");
//			swap(chs, x, y); 
//			System.out.println(new String(chs));
//			
//			x++;
//			y++;
//			
//			if (y == chs.length) y = 0;
//			
//			if (x == chs.length) x = 0;
//		}
		
		
		
	}
	
	public static void swap(char[] word, int i, int j) {
		if (i > word.length - 1 || j > word.length - 1) throw new IllegalArgumentException();
		
		char c = word[i];
		word[i] = word[j];
		word[j] = c;
	}
	
	public static int fact(int num) {
		if(num == 1) return 1;
		
		return num * fact(num-1);
	}

}
