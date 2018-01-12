package com.hackerrank.thirtydaysofcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day8 {
  public static void main(String []argh){
      Map<String, Integer> dict = new HashMap<String, Integer>();
      
      Scanner in = new Scanner(System.in);
      int n = in.nextInt();
      for(int i = 0; i < n; i++){
          String name = in.next();
          int phone = in.nextInt();
          dict.put(name, phone);
      }
      while(in.hasNext()){
          String s = in.next();
          Integer phone = dict.get(s);
          if (phone == null) System.out.println("Not found");
          else System.out.println(s + "=" + phone);
      }
      in.close();
  }
}
