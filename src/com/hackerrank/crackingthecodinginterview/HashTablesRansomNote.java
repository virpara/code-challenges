package com.hackerrank.crackingthecodinginterview;

import java.util.*;

public class HashTablesRansomNote {
    Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;
    
    public HashTablesRansomNote(String magazine, String note) {
        magazineMap = new HashMap<String, Integer>();
        noteMap = new HashMap<String, Integer>();
        
        Integer val;
        
        for (String s : magazine.split(" ")) {
        	if (s.isEmpty()) continue;
        	
        	val = magazineMap.get(s);
        	if (val != null) val++;
        	else val = 1;
        	
        	magazineMap.put(s, val);
        }
        
        for (String s : note.split(" ")) {
        	if (s.isEmpty()) continue;
        	
        	val = noteMap.get(s);
        	if (val != null) val++;
        	else val = 1;
        	
        	noteMap.put(s, val);
        }
        
        System.out.println("magazineMap=" + magazineMap);
        System.out.println("noteMap=" + noteMap);
        
    }
    
    public boolean solve() {
    	
    	for (Map.Entry<String, Integer> entry : noteMap.entrySet()) {
    		String noteWord = entry.getKey();
    		Integer noteWOccu = entry.getValue();
    		
    		Integer magWOccu = magazineMap.get(noteWord);
    		
    		if (magWOccu == null || magWOccu < noteWOccu) return false; // didn't find the word in mag text
    	}
        
    	if (noteMap.size() > 0) return true;
    	else return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        scanner.close();
        // Eat whitespace to beginning of next line
        scanner.nextLine();
        
        HashTablesRansomNote s = new HashTablesRansomNote(scanner.nextLine(), scanner.nextLine());
        scanner.close();
        
        boolean answer = s.solve();
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");
      
    }
}
