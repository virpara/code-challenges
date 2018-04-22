package com.javatests;

public class StringTest {

    public static void main(String[] args) {
        String a = "abc";
        String b = "abc";
        String c = new String("abc");
        String d = a.toString();
        String e = a;

        System.out.println("a == b " + (a == b));
        System.out.println("a == c " + (a == c));
        System.out.println("a == d " + (a == d));
        System.out.println("a == e " + (a == e));
        System.out.println("a.equals(c) " + a.equals(c));
        System.out.println("b.equals(d) " + b.equals(d));
    }
}
