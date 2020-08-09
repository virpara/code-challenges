package com.idealo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// count the number of occurrence of characters from the given string case-insensitively

class CountCharOccurrence {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		String str = s.nextLine();

		Map<Character, Integer> map = new HashMap<>();

		for (char c : str.toUpperCase().toCharArray()) {
			map.compute(c, (key, val) -> val == null ? 1 : val++);
		}
		s.close();
		
		System.out.println(map);
	}
}