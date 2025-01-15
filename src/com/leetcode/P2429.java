package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class P2429 {

    @Test
    void test() {
        int[][] input = {
                {3, 5},
                {1, 12}
        };
        int[] exp = {3, 3};
        for (int i = 0; i < input.length; i++) {
            Assertions.assertEquals(exp[i], minimizeXor(input[i][0], input[i][1]));
        }
    }

    public int minimizeXor(int num1, int num2) {
        int bits2 = Integer.bitCount(num2);
        int bits1 = Integer.bitCount(num1);

        if (bits2 == bits1) return num1;

        while (bits2 != bits1) { // repeat until the bits1 is same as bits2
            if (bits2 > bits1) {
                // set atleast bits1 bits or take the num1 since it would already have bits1 bits set
                // set remaining bits (bits2 - bits1) from least significat (left to right)
                num1 |= num1 + 1; // sets rightmost bit
            } else {
                // less bits to set than in num1 so
                // unset (bits1 - bits2) least significat bit from num1
                num1 &= num1 - 1;  // unsets rightmost bit
            }

            bits1 = Integer.bitCount(num1);
        }

        return num1;
    }

}
