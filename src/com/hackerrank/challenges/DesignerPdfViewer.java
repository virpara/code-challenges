package com.hackerrank.challenges;

import java.util.Scanner;

public class DesignerPdfViewer {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] h = new int[26];
        for(int h_i=0; h_i < 26; h_i++){
            h[h_i] = in.nextInt();
        }
        String word = in.next();
        
        in.close();
                
        // formula num_of_chars * width_of_char * max_height_of_char_in_word
        int width = 1;
        char[] ch = word.toCharArray();
        int maxH = 0, alphNum, temph = 0;
        char c;
        
        // find max height
        for (int i = 0; i < ch.length; i++) {
            c = ch[i];
            alphNum = c - 97;
            temph = h[alphNum];
            
            if (temph > maxH) maxH = temph;
            
        }
        int area = word.length() * width * maxH;
        
        System.out.println(area);
    }
}