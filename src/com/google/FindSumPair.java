package com.google;

import java.util.HashSet;
import java.util.Set;

public class FindSumPair {
    public static void main(String[] args) {
        int sum = 8;
        int[] array = {1, 2, 4, 4};
        int[] array2 = {4, 2, 3, 7};

        System.out.println(hasPairWithSumForUnsortedArray(array, sum));
        System.out.println(hasPairWithSumForUnsortedArray(array2, sum));

        int[] array3 = {7, 5, 4, 3, 2}; // fails with random or descending order

        System.out.println(hasPairWithSum(array, sum));
        System.out.println(hasPairWithSum(array3, sum));
    }

    // works with sorted array only
    private static boolean hasPairWithSum(int[] array, int sum) {

        int low = 0;
        int high = array.length - 1;

        while (low < high) {
            int s = array[low] + array[high];
            if (s == sum) {
                return true;
            } else if (s < sum) {
                low++;
            } else {
                high--;
            }
        }

        return false;
    }

    private static boolean hasPairWithSumForUnsortedArray(int[] data, int sum) {
        Set<Integer> complements = new HashSet<>();
        for(int a : data) {
            if (complements.contains(a))
                return true;
            else
                complements.add(sum - a);
        }

        return false;
    }
}
