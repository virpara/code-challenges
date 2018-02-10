package com.prob.recursion;

public class Palindrome {

	public static void main(String[] args) {
		String s = "abcbaa";
		char[] chs = s.toCharArray();
		System.out.println(isPalindrome(chs, 0, chs.length-1));

	}

	private static boolean isPalindrome(char[] s, int i, int j) {
		if (j - i < 1) {
			return true;
		} else if (s[i] == s[j]) {
			return isPalindrome(s, i+1, j-1);
		} else {
			return false;
		}
	}

}
