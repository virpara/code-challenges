package com.hackerrank.thirtydaysofcode;

import java.util.LinkedList;
import java.util.Scanner;

public class Day23 {
	static class Node {
	    Node left,right;
	    int data;
	    Node(int data){
	        this.data=data;
	        left=right=null;
	    }
	}
	
	static void levelOrder (Node root) {
        if (root != null) {
            LinkedList<Node> q = new LinkedList<Node>();
            
            q.offer(root);
            
            while (q.size() > 0) {
                Node n = q.poll();
                System.out.print(n.data + " ");
                
                Node l = n.left;
                Node r = n.right;
                if (l != null) {
                    q.offer(l);
                }
                if (r != null) {
                    q.offer(r);
                }
            }
        }
      
    }
	
	public static Node insert(Node root, int data) {
		if (root == null) {
			return new Node(data);
		} else {
			Node cur;
			if (data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		Node root = null;
		while (T-- > 0) {
			int data = sc.nextInt();
			root = insert(root, data);
		}
		sc.close();
		levelOrder(root);
	}
}
