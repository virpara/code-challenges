package book.ita.lec1;

public class PeakFinding {

	public static void main(String[] args) {
		int[] n = {};
		
		System.out.println(findPeakElement(n));
	}

	private static int oneDimPeakFind(int[] n, int start, int end) {
		
		int diff = end - start;
		System.out.println("diff=" + diff);
		if (diff < 0) {
			return -1;
		} else if (diff == 0) {
			return start;
		} else if (diff == 1) {
			if (n[end] > n[start]) return end;
			else return start;
		} else {
			int mid = (start + end) / 2;
			System.out.println("mid=" + mid);
			if (n[mid] > n[mid-1] && n[mid] > n[mid+1]) {
				return mid;
			} else if (n[mid-1] >= n[mid]) {
				return oneDimPeakFind(n, start, mid-1);
			} else if (n[mid+1] >= n[mid]) {
				return oneDimPeakFind(n, mid+1, end);
			} else {
				return -99;
			}
		}
	}
	
	public static int findPeakElement(int[] nums) {
        
		return oneDimPeakFind(nums, 0, nums.length - 1);
    }

}
