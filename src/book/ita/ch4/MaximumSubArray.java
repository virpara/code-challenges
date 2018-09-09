package book.ita.ch4;

import com.util.Scan;

import java.util.Arrays;
import java.util.Random;

// todo: exercises 4.1-4, 4.1-5
// Exercise 4.1-1 : it returns the biggest number from all negative numbers

public class MaximumSubArray {
    public static void main(String[] args) {

        int n = Scan.ni();
//        Integer[] a = Scan.nIa(n);
        Scan.close();

        long start = 0L;
        long end = 0L;
        long ddTime = 0L;
        long bTime = 0L;
        Integer[] ans = null;
        Integer[] a = null;
        Random r = new Random();

        // Exercise 4.1-3 problem size 24 to 30 is the crossover point
        // run various problem sizes to find the n-zero after which divide and conquer solution is faster
        for (int x = 5; x <= n; x++) {
            a = new Integer[x];
            for (int y = 0; y < x; y++) {
                a[y] = r.nextInt();
            }

            // run the test
            start = System.nanoTime();
            ans = findMaximumSubarray(a, 0, a.length - 1);
            end = System.nanoTime();
            ddTime = end - start;
            System.out.println("Divide and Conquer: " + ddTime + " ns " + Arrays.asList(ans));

            start = System.nanoTime();
            ans = findMaximumSubarrayBruteForce(a, 0, a.length - 1);
            end = System.nanoTime();
            bTime = end - start;
            System.out.println("Brute force: " + bTime + " ns " + Arrays.asList(ans));

            String winner = bTime < ddTime ? "Brute Force" : "DD";
            System.out.println("Problem size " + x + " winner is " + winner);
        }

    }

    // Exercise 4.1-2 brute force method
    private static Integer[] findMaximumSubarrayBruteForce(Integer[] a, int low, int high) {
        int maxSum = Integer.MIN_VALUE;
        int maxi = 0;
        int maxj = 0;

        for (int i = low; i < high; i++) {
            int sum = 0;

            for (int j = i; j < high; j++) {
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
//             use brute force for problem size less than crossover point
//            if (high - low < 30) {
//                return findMaximumSubarrayBruteForce(a, low, high);
//            }

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

        return new Integer[]{maxLeft, maxRight, leftSum + rightSum};
    }
}
