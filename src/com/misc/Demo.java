package com.misc;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import javax.security.auth.login.CredentialExpiredException;

public class Demo {
	enum CountryAndOneContinent {

	    INDIA("India"),
	    RUSSIA("Russia"),
	    NORTH_AMERICA("North America");

	    private String displayName;

	    CountryAndOneContinent(String displayName) {
	        this.displayName = displayName;
	    }

	    public String displayName() { return displayName; }

	    // Optionally and/or additionally, toString.
	    @Override public String toString() { return displayName; }
	}
	
	public static void main(String[] args) {
		
		Kingdom air = new Kingdom("Air", "Owl");
		Kingdom land = new Kingdom("Land", "Panda");
		Kingdom ice = new Kingdom("Ice", "Mammoth");
		Kingdom water = new Kingdom("Water", "Octopus");
		Kingdom fire = new Kingdom("Fire", "Dragon");
		
		/*System.out.println("Air: " + Kingdom.isWin("Air, \"Let’s swing the sword together\""));
		System.out.println("Land: " + Kingdom.isWin("Land, \"Die orplay the tame of thrones\""));
		System.out.println("Ice: " + Kingdom.isWin("Ice, \"Ahoy! Fight for me with men and money\""));
		System.out.println("Water: " + Kingdom.isWin("Water, \"Summer is coming\""));
		System.out.println("Fire: " + Kingdom.isWin("Fire, \"Drag on Martin!\""));*/
		
		//System.out.println(CountryAndOneContinent.values());
		
		
//		System.out.println("hello");
//		
//		String a[] = new String[3];
//		
//		Scanner sc = new Scanner(System.in);
//		
//		for(int i = 0; i < 3; i++){
//			
//			a[i] = sc.nextLine(); 
//		}
//		
//		System.out.println(Arrays.asList(a));

	}
	
	public static class Kingdom {
		private String name = null;
		private String emblem = null;
		private Map<Character, Integer> emblemStruct = new HashMap<Character, Integer>();
		
		public Kingdom(String name, String emblem) {
			this.name = name.toUpperCase();
			this.emblem = name.toUpperCase();
			emblemStruct = createStruct(emblem);
		}
		
		protected Map<Character, Integer> getEmblemStruct() {
			return emblemStruct;
		}

		public boolean isWin(String message){
			// format: <Kingdom Name>, "<Secret Message>"
			
			if(message == null || message.indexOf(",") == -1)
				throw new IllegalArgumentException("Message should not be null and in proper format");
			
			message = message.toUpperCase();
			
			//String toWinKingdom = message.substring(0, message.indexOf(","));
			String secretMsg = message.substring(message.indexOf("\"")+1, message.lastIndexOf("\""));
			
			secretMsg = secretMsg.replaceAll("\\W", "");
			
			System.out.println("toWinKingdom: " + name);
			System.out.println("secretMsg: " + secretMsg);
			
			// prepare simple structure having character as key and number of occurrence as value
			Map<Character, Integer> secretMsgStruct = createStruct(secretMsg);
			
			boolean isWin = true;
			for(Map.Entry<Character, Integer> entry : emblemStruct.entrySet()){
				Character key = entry.getKey();
				Integer val = entry.getValue();
						
				Integer count;
				if((count = secretMsgStruct.get(key)) == null || count < val){
					isWin = false;
					break;
				}
			}
			return isWin;
		}
		
//		private static Map<Character, Integer> createNameStruc(String toWinKingdom) {
//			if("AIR".equalsIgnoreCase(toWinKingdom)){
//				return createStruct("OWL");
//			} else if("LAND".equalsIgnoreCase(toWinKingdom)){
//				return createStruct("PANDA");
//			} else if("WATER".equalsIgnoreCase(toWinKingdom)){
//				return createStruct("OCTOPUS");
//			} else if("ICE".equalsIgnoreCase(toWinKingdom)){
//				return createStruct("MAMMOTH");
//			} else if("FIRE".equalsIgnoreCase(toWinKingdom)){
//				return createStruct("DRAGON");
//			}
//			return null;
//		}

		private static Map<Character, Integer> createStruct(String s){
			// prepare simple structure having character as key and number of occurrence as value
			Map<Character, Integer> simpleStruct = new HashMap<Character, Integer>();
			for(Character c : s.toCharArray()){
				Integer charCount;
				
				if((charCount = simpleStruct.get(c)) == null)
					simpleStruct.put(c, 0);
				else
					simpleStruct.put(c, charCount++);
				
			}
			return simpleStruct;
		}
	}
	
	public class RulerKingShan {
		
	}

}
