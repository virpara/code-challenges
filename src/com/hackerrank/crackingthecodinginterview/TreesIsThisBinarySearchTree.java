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
		if (root != null) {
            Node left = root.left;
            Node right = root.right;
            
            System.out.println(" root=" + root + ", left=" + left + ", right=" + right);
            
            boolean l = true, r = true;
            if ( left != null) {
            	// to check each element in the left tree is less than or equal to root value.
            	
                if (left.data <= root.data) {
                    //System.out.print(", left.data=" + left.data);
                    l = isBSTLeft(left, root);
                } else 
                    l = false;
                
            }
            
            if (right != null) {
            	// each element in the right tree is greater than root value
            	
            	if (right.data > root.data) {
                    //System.out.print(", right.data=" + right.data);
                    r = isBSTRight(right, root);
                } else
                    r = false;
            }
            
            return (l && r);
            
        } else return true;
	}
	
	boolean isBSTLeft(Node curr, Node prev) {
		if (curr != null) {
            Node left = curr.left;
            Node right = curr.right;
            
            boolean l = true, r = true;
            if ( left != null) {
            	// to check each element in the left tree is less than or equal to root value.
            	
                if (left.data <= curr.data) {
                    //System.out.print(", left.data=" + left.data);
                    l = isBSTLeft(left, prev);
                } else {
                	l = false;
                }
                
            }
            
            if (right != null) {
            	// each element in the right tree is greater than root value
            	
            	if (right.data > curr.data) {
                    //System.out.print(", right.data=" + right.data);
                    r = isBSTRight(right, prev);
                } else
                    r = false;
            } else if (curr.data > prev.data) {
            	r = false;
            }
            
            return (l && r);
            
        } else return true;
		
	}
	
	boolean isBSTRight(Node curr, Node prev) {
		if (curr != null) {
            Node left = curr.left;
            Node right = curr.right;
            
            boolean l = true, r = true;
            if ( left != null) {
            	// to check each element in the left tree is less than or equal to root value.
            	
                if (left.data <= curr.data) {
                    //System.out.print(", left.data=" + left.data);
                    l = isBSTLeft(left, prev);
                } else 
                    l = false;
                
            } else if (curr.data <= prev.data) {
            	l = false;
            }
            
            if (right != null) {
            	// each element in the right tree is greater than root value
            	
            	if (right.data > curr.data) {
                    //System.out.print(", right.data=" + right.data);
                    r = isBSTRight(right, prev);
                } else
                    r = false;
            }
            
            return (l && r);
            
        } else return true;
		
	}
	

	public static void main() {
		
	}
}
