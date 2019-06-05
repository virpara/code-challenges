package com.idealo;

import java.util.*;

// count the number of occurrence of characters from the given string

class CountCharOccurrence {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		String str = s.next();

		Map<Character, Integer> map = new HashMap<>();

		for (char c : str.toUpperCase().toCharArray()) {
			Integer count = map.get(c);

			if (count != null) {
				count++;
				map.put(c, count);
			} else {
				map.put(c, 1);
			}
		}
		s.close();
		
		System.out.println(map);
	}
}