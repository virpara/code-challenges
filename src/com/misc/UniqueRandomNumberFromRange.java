package com.misc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
Generate unique random number in the specified range with equal distribution.
 */

public class UniqueRandomNumberFromRange {

    private final int start;
    private final int end;

    private final List<Integer> randomNums;
    private int currIndex = 0;

    public UniqueRandomNumberFromRange(int start, int end) {
        this.start = start;
        this.end = end;

        if (start > end) throw new IllegalArgumentException("start must be smaller than end");

        int size = end + 1 - start; // inclusive range so end + 1
        randomNums = new ArrayList<>(size);
        for (int i = start; i <= end; i++) {
            randomNums.add(i);
        }

        Random r = new Random();
        for (int i = 0; i < size; i++) { // consider until middle element
            int randPosition = r.nextInt(end);
            swap(i, randPosition);
        }
    }

    public static void main(String[] args) {
        UniqueRandomNumberFromRange u = new UniqueRandomNumberFromRange(1, 100);

        for (int i = 0; i < 101; i++) {
            System.out.println(u.getUniqueRandomNum());
        }
    }

    public int getUniqueRandomNum() {
        if (currIndex >= randomNums.size())
            throw new IllegalStateException("All unique random numbers are already generated");

        return randomNums.get(currIndex++);
    }

    private void swap(int i, int j) {
        int temp = randomNums.get(i);
        randomNums.set(i, randomNums.get(j));
        randomNums.set(j, temp);
    }
}
