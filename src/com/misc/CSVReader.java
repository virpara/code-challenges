package com.misc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVReader {

    public static void main(String[] args) {
        String csvFile = "C:/ActiveMember.csv";
        String line = "";
        String csvDelim = ",";
        
        List<String[]> lines = new ArrayList<String[]>();
        
        BufferedReader br = null;
        FileWriter writer = null;
        
        //read lines
        try {
			br = new BufferedReader(new FileReader(csvFile));
			int i = 0;
			
			while ((line = br.readLine()) != null) {
				
				// split columns
				String[] cols = line.split(csvDelim);
				
				// break if any column contains Summary word
				if (Arrays.asList(cols).contains("Summary")) {
					break;
				}
				
				if (cols.length > 0) {
					if (i == 1) { // cannot do anything for the first line because there is no previous line
						
						lines.add(cols);
						i++;
					} else {
						if (cols[0].isEmpty()) { // merge with previous column
							String[] prevLine = lines.remove(lines.size() - 1);
							
							if (cols.length > 2) { // can only if there is more than two columns
								for (int j = 1; j < prevLine.length; j++) {
									String currCol = cols[j];
									String prevCol = prevLine[j];
									
									prevLine[j] = prevCol + "-" + currCol;
									
								}
							}
							lines.add(prevLine);
							
						} else {
							lines.add(cols);
						}
						
					}
				} else {
					System.out.println("zero columns in the line!");
				}
				
			}
			
			// write file
			
			String newCsv = "C:/ActiveMember1.csv";
			writer = new FileWriter(newCsv);
			for (String[] cols : lines) {
				String lineStr = "";
				for (int j = 0; j < cols.length; j++) {
					lineStr += cols[j] + (j == cols.length - 1 ? "" : csvDelim);
				}
				//System.out.println(lineStr);
				writer.append(lineStr + System.lineSeparator());
			}
			System.out.println("CSV File written successfully line by line");
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if (writer != null) {
				try {
					writer.flush();
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
        
        
        //merge data
        
        
        
    }
}