package com.hackerrank.challenges;

import java.util.Scanner;

public class TimeConversion {

    static String timeConversion(String s) {
        String time = s.substring(2, s.length() - 2);
        String hr = s.substring(0, 2);
        String am = s.substring(s.length() - 2, s.length());
        
        try {
            int h = Integer.parseInt(hr);
            
            hr = "00";
            if ("AM".equalsIgnoreCase(am) && h > 1 && h < 10) hr = "0" + h ;
            else if ("AM".equalsIgnoreCase(am) && h < 12) hr = h + "";
            else if ("PM".equalsIgnoreCase(am)) {
                hr = h < 12 ? h + 12 + "" : h + "";
            }
            
        } catch(Exception e) {
            
        }
        
        return hr + time;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        in.close();
        String result = timeConversion(s);
        System.out.println(result);
    }
}
