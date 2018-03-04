package book.ita.lec1;

public class PeakFinding {

    public static void main(String[] args) {
        int[] n = {8,7,6,5,4};

        System.out.println(findPeakElement(n));
        System.out.println(findPeakLinearly(n));
    }

    // one dimension peak finding by scanning 0 to n elements
    private static int findPeakLinearly(int[] nums) {
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

    private static int findPeakElement(int[] nums) {
        return oneDimPeakFind(nums, 0, nums.length - 1);
    }

    // using binary search
    private static int oneDimPeakFind(int[] n, int start, int end) {

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
                return oneDimPeakFind(n, start, mid - 1);
            } else if (n[mid] < n[mid + 1]) {
                // look at right half
                return oneDimPeakFind(n, mid + 1, end);
            } else {
                // why is it a peak?
                // a[n/2] >= a[n/2 - 1]
                // a[n/2] >= a[n/2 + 1]
                return mid;
            }
        }
    }


}
