package com.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AmazonProb2 {

	public static void main(String[] args) {
		String[][] menuPair = { { "Italian", "Pizza" }, { "Indian", "Masala" }, { "Indian", "Spicy" } };
		String[][] teamMember = { { "Jose", "Italian" }, { "John", "Indian" }, { "Mary", "*" } };
		
		String[][] possiblePair = possiblePair(menuPair, teamMember);
		System.out.println("[");
		for(int i = 0; i < possiblePair.length; i++) {
			System.out.println(Arrays.asList(possiblePair[i]));
		}
		System.out.println("]");
	}

	public static String[][] possiblePair(String[][] menuPair, String[][] teamMember) {
		String[][] possiblePair = new String[100][];

		Map<String, List<String>> menu = new HashMap<String, List<String>>();

		for (int i = 0; i < menuPair.length; i++) {
			List<String> list = menu.get(menuPair[i][0]);

			if (list != null) {
				list.add(menuPair[i][1]);
			} else {
				list = new ArrayList<String>();
				list.add(menuPair[i][1]);
			}
			menu.put(menuPair[i][0], list);
		}
		
		System.out.println("menuMap=" + menu);
		
		int count = 0;
		for(int i = 0; i < teamMember.length; i++) {
			String user = teamMember[i][0];
			String cuisine = teamMember[i][1];
			
			if("*".equals(cuisine)) {
				for(String key : menu.keySet()) {
					for(String c : menu.get(key)){						
						possiblePair[count] = new String[2];
						possiblePair[count][0] = user;
						possiblePair[count][1] = c;
						count++;
					}					
				}
			} else {
				for(String c : menu.get(cuisine)) {
					possiblePair[count] = new String[2];
					possiblePair[count][0] = user;
					possiblePair[count][1] = c;
					
					count++;
				}
			}
		}
		
		System.out.println("count="+ count);
		return Arrays.copyOf(possiblePair, count);
		//return possiblePair;
	}
}
