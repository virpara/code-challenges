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
		
		prepare(chs, 1);
		
	}
	public static void prepare(char[] w, int i) {
		System.out.println(String.valueOf(w));
		if (i <= w.length-1) {
			swap(w, 0, i);
			prepare(w, i+1);
		}
		
		
	}
	public static void anagram(char[] w, int a, int i, int j) {
		
	}
	
	public static void swap(char[] word, int i, int j) {
//		if (i > word.length - 1 || j > word.length - 1) throw new IllegalArgumentException();
		
		char c = word[i];
		word[i] = word[j];
		word[j] = c;
	}
	

}
