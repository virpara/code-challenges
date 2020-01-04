package com.misc.array;

public class Array1 {

	public static void main(String[] args) {

	}

	/*
	 * Given 2 arrays of ints, a and b, return true if they have the same first
	 * element or they have the same last element. Both arrays will be length 1
	 * or more.
	 * 
	 * commonEnd([1, 2, 3], [7, 3]) -> true
	 * 
	 * commonEnd([1, 2, 3], [7, 3, 2]) -> false
	 * 
	 * commonEnd([1, 2, 3], [1, 3]) -> true
	 */
	public static boolean commonEnd(int[] a, int[] b) {
		if (a.length == 0 || b.length == 0)
			return false;
		else if (a.length == 1 && b.length == 0)
			return a[0] == b[0];
		else {
			return a[0] == b[0] || a[a.length - 1] == b[b.length - 1];
		}
	}

	/*
	 * Given an array of ints length 3, return the sum of all the elements.
	 * 
	 * sum3([1, 2, 3]) -> 6
	 * 
	 * sum3([5, 11, 2]) -> 18
	 * 
	 * sum3([7, 0, 0]) -> 7
	 */
	public int sum3(int[] nums) {
		int sum = 0;
		for (int i : nums) {
			sum += i;
		}

		return sum;
	}

	/*
	 * Given an array of ints length 3, return an array with the elements
	 * "rotated left" so {1, 2, 3} yields {2, 3, 1}.
	 * 
	 * rotateLeft3([1, 2, 3]) -> [2, 3, 1]
	 * 
	 * rotateLeft3([5, 11, 9]) -> [11, 9, 5]
	 * 
	 * rotateLeft3([7, 0, 0]) -> [0, 0, 7]
	 */
	public int[] rotateLeft3(int[] nums) {

//		System.arraycopy(nums, 1, i, 0, nums.length - 1);
//		i[0] = nums[0];
		
		int j = nums[0];
		for(int i = 1; i < nums.length; i++) 
			nums[i-1] = nums[i];
		
		nums[nums.length-1] = j;
		
		return nums;
	}
}
