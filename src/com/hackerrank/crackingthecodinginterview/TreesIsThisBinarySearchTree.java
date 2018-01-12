package com.hackerrank.crackingthecodinginterview;

public class TreesIsThisBinarySearchTree {
	/*
	 * Hidden stub code will pass a root argument to the function below.
	 * Complete the function to solve the challenge. Hint: you may want to write
	 * one or more helper functions.
	 * 
	 */
	
	// TODO
	class Node {
		int data;
		Node left;
		Node right;
	}

	boolean checkBST(Node root) {
		if (root == null)
			return false;
		
		Node left = root.left;
		Node right = root.right;
		
		boolean isBst = false;
		
		if (left == null && right == null) {
			return true;
		}

		if (left == null || right == null) {
			return false;
		}
		
		if (left.data > root.data || right.data < root.data) {
			return false;
		} else {
			isBst = checkBST(left) && checkBST(right);
		}
		
		
		return isBst;
	}
	
	public static void main() {
		
	}
}
