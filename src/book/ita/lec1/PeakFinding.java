package book.ita.lec1;

public class PeakFinding {

    public static void main(String[] args) {
        int[] n = {8,7,6,5,4};

        System.out.println("find1dPeakElement: " + find1dPeakElement(n));
        System.out.println("find1dPeakLinearly: " + find1dPeakLinearly(n));
        System.out.println("find1dPeakCleverLinearly: " + find1dPeakCleverLinearly(n));

        int[][] p = {{1,2,0,0,0}, {2,3,2,0,0}, {3,4,1,0,0}, {4,5,0,0,0}, {5,6,7,0,0}};
        System.out.println("findPeak2dGreedyAscent: " + findPeak2dGreedyAscent(p));
        System.out.println("findPeak2dBruteForce: " + findPeak2dBruteForce(p));
    }

    /**
     * Find 2d peak by Greedy Ascent algorithm
     * @param n two matrix to find peak from
     * @return a peak value in the input matrix
     */
    private static int findPeak2dGreedyAscent(int[][] n) {
        return findPeak2dGreedyAscent(n, 0, 0);
    }

    private static int findPeak2dGreedyAscent(int[][] n, int i, int j) {
        //System.out.println("i=" + i + " j=" + j);

        // top element is greater or equal
        if (i - 1 >= 0 && n[i][j] <= n[i - 1][j]) return findPeak2dGreedyAscent(n, i - 1, j);

        // bottom element is greater or equal
        else if (i + 1 < n.length && n[i][j] <= n[i + 1][j]) return findPeak2dGreedyAscent(n, i + 1, j);

        // left element is greater or equal
        else if (j - 1 >= 0 && n[i][j] <= n[i][j-1]) return findPeak2dGreedyAscent(n, i, j - 1);

        // right element is greater or equal
        else if (j + 1 < n[i].length && n[i][j] <= n[i][j + 1]) return findPeak2dGreedyAscent(n, i, j + 1);

        // neither condition is true, so it is a 2d peak
        else return n[i][j];

    }

    /**
     * Find 2d peak by brute-force
     * @param n 2d matrix to look for a peak
     * @return a 2d peak from the input matrix
     */
    private static int findPeak2dBruteForce(int[][] n) {
        for (int i = 0; i < n.length-1; i++) {
            int[] row = n[i];
            for (int j = 0; j < row.length-1; j++) {
                //System.out.println("i=" + i + " j=" + j);
                if (is2dPeak(n, i, j)) {
                    return n[i][j];
                }
            }
        }

        return -1;
    }

    /**
     * Find if the specified element is a 2d peak
     * @param n two dimensional integer array to check for 2d peak.
     * @param row row of the element
     * @param col column of the element
     * @return true if <code>n[row][col]</code> is a 2d peak
     */
    private static boolean is2dPeak(int[][] n, int row, int col) {
        // check the top element
        if (row - 1 >= 0 && n[row][col] < n[row - 1][col]) return false;

        // check the bottom element
        if (row + 1 < n.length && n[row][col] < n[row + 1][col]) return false;

        // check the left element
        if (col - 1 >= 0 && n[row][col] < n[row][col - 1]) return false;

        // check the right element
        if (col + 1 < n[row].length && n[row][col] < n[row][col + 1]) return false;

        // top, bottom, left, right elements are less or equal n[row][col]
        return true;
    }

    // one dimension peak finding by scanning 0 to n elements
    private static int find1dPeakLinearly(int[] nums) {
        if (nums.length == 1) return 0;

        for (int i = 0; i < nums.length; i++) {
            if (i == 0 && nums[i] >= nums[i+1]) return i;
            else if (i == nums.length-1 && nums[i] >= nums[i-1]) return i;
            else if (i > 1 && i < nums.length-1) {
                if (nums[i] >= nums[i-1] && nums[i] >= nums[i+1]) return i;
            }
        }

        return -1;
    }

    // clever linear solution
    private static int find1dPeakCleverLinearly(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return i-1;
            }
        }

        return nums.length - 1;
    }

    private static int find1dPeakElement(int[] nums) {
        return find1dPeak(nums, 0, nums.length - 1);
    }

    // using binary search
    private static int find1dPeak(int[] n, int start, int end) {

        int diff = end - start;
        if (diff < 0) {
            return -1;
        } else if (diff == 0) {
            return start;
        } else if (diff == 1) {
            if (n[start] > n[end]) return start;
            else return end;
        } else {
            int mid = (start + end) / 2;

            if (n[mid] < n[mid - 1]) {
                // look at left half
                return find1dPeak(n, start, mid - 1);
            } else if (n[mid] < n[mid + 1]) {
                // look at right half
                return find1dPeak(n, mid + 1, end);
            } else {
                // why is it a peak?
                // a[n/2] >= a[n/2 - 1]
                // a[n/2] >= a[n/2 + 1]
                return mid;
            }
        }
    }


}
