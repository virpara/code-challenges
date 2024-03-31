package com.misc;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class AnagramWithJava8 {

    public static void main(String[] args) {
        String a = "RaceCar";
        String b = "CarRace";

        System.out.println(isAnagram(a, b));
    }

    private static boolean isAnagram2(String a, String b) {
        char[] aChars = a.toCharArray();
        Arrays.sort(aChars);

        char[] bChars = b.toCharArray();
        Arrays.sort(bChars);

        if (aChars.length != bChars.length) {
            return false;
        } else {
            long count = IntStream.range(0, aChars.length)
                    .filter(idx -> aChars[idx] == bChars[idx])
                    .count();

            return count == aChars.length;
        }

    }

    private static boolean isAnagram(String a, String b) {
        int[] bChars = b.chars().sorted().toArray();
        AtomicInteger i = new AtomicInteger(0);

        long matchingCount = a.chars()
                .sorted()
                .filter(ch -> ch == bChars[i.getAndAdd(1)])
                .count();

        return matchingCount == bChars.length;
    }
}
