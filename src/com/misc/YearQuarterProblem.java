package com.misc;

public class YearQuarterProblem {

	public static void main(String[] args) {
		if (args.length <= 0) {
			System.out.println("Please provide quarter number.");
			return;
		}
		
		int numOfMonths = 12;
		for (String arg : args) {
			//System.out.println("arg="  + arg);
			
			int month = -1;
			try {				
				month = Integer.parseInt(arg);
			} catch (NumberFormatException ne) {
				System.out.println(arg + " is not a number.");
				continue;
			}
			
			if (month > numOfMonths || month < 1) {
				System.out.println("input should be between 1 to " + numOfMonths + ". Got " + month);
				continue;
			}
			
			int monthsInAQuarter = numOfMonths/4; // 3
			int foundMonthNumInQuarter = (month - 1) % 4;
			int foundQuarter = 0;
			
			if (month <= 1 * monthsInAQuarter) {
				foundQuarter = 1;
			} else if (month <= 2 * monthsInAQuarter) {
				foundQuarter = 2;
			} else if (month <= 3 * monthsInAQuarter) {
				foundQuarter = 3;
			} else if (month <= 4 * monthsInAQuarter) {
				foundQuarter = 4;
			}
			
			System.out.println("Month: " + month + " Quarter: " + foundQuarter + " Quarter month: " + (foundMonthNumInQuarter + 1));
			
		}

	}

}
