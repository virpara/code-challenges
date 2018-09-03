package book.ita.ch4;

import com.util.Scan;

import java.util.Arrays;

public class MaximumSubArray {
    public static void main(String[] args) {

        int n = Scan.ni();
        Integer[] a = Scan.nIa(n);
        Scan.close();

        System.out.println(Arrays.asList(findMaximumSubarray(a, 0, a.length - 1)));
        System.out.println(Arrays.asList(findMaximumSubarrayBruteForce(a)));
    }

    // Exercise 4.1-2 brute force method
    private static Integer[] findMaximumSubarrayBruteForce(Integer[] a) {
        int maxSum = Integer.MIN_VALUE;
        int maxi = 0;
        int maxj = 0;

        for (int i = 0; i < a.length; i++) {
            int sum = 0;

            for (int j = i; j < a.length; j++) {
                sum = sum + a[j];
                if (sum > maxSum) {
                    maxSum = sum;
                    maxi = i;
                    maxj = j;
                }
            }
        }

        Integer[] ret = {maxi, maxj, maxSum};
        return ret;
    }

    // n log n solution
    private static Integer[] findMaximumSubarray(Integer[] a, int low, int high) {
        Integer[] ret = {low, high, a[low]};

        if (high == low) { // base case: only one element
            return ret;
        } else {
            int mid = (low + high) / 2;
            Integer[] left = findMaximumSubarray(a, low, mid);
            Integer[] right = findMaximumSubarray(a, mid + 1, high);
            Integer[] cross = findMaxCrossingSubarray(a, low, mid, high);

            if (left[2] >= right[2] && left[2] >= cross[2])
                return left;
            else if (right[2] >= left[2] && right[2] >= cross[2])
                return right;
            else
                return cross;
        }

    }

    private static Integer[] findMaxCrossingSubarray(Integer[] a, int low, int mid, int high) {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        int maxLeft = mid;

        for (int i = mid; i >= low; i--) {
            sum = sum + a[i];
            if (sum > leftSum) {
                leftSum = sum;
                maxLeft = i;
            }
        }

        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        int maxRight = mid + 1;

        for (int j = mid + 1; j <= high; j++) {
            sum = sum + a[j];
            if (sum > rightSum) {
                rightSum = sum;
                maxRight = j;
            }
        }

        Integer[] ret = {maxLeft, maxRight, leftSum + rightSum};
        return ret;
    }
}
