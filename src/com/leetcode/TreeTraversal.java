package com.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class TreeTraversal {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // pre-order binary tree traversal (iterative)
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();

        Deque<TreeNode> stk = new ArrayDeque<TreeNode>();

        if (root != null) stk.push(root);
        while (stk.size() > 0) {
            TreeNode tmp = stk.pop();
            if (tmp != null) {
                traversal.add(tmp.val);
                if (tmp.right != null) stk.push(tmp.right);

                if (tmp.left != null) stk.push(tmp.left);
            }
        }

        return traversal;
    }

    public List<Integer> preorderTraversalRecursive(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        preorderTraversalHelper(root, traversal);
        return traversal;
    }

    private void preorderTraversalHelper(TreeNode t, List<Integer> l) {
        if (t != null) {
            l.add(t.val);
            if (t.left != null) preorderTraversalHelper(t.left, l);
            if (t.right != null) preorderTraversalHelper(t.right, l);
        }
    }

    // TODO in-order binary tree traversal (iterative)
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();


        return traversal;
    }

    // in-order binary tree traversal (recursive)
    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        inorderTraversalHelper(root, traversal);

        return traversal;
    }

    private void inorderTraversalHelper(TreeNode t, List<Integer> traversal) {
        if (t != null) {
            if (t.left != null) inorderTraversalHelper(t.left, traversal);
            traversal.add(t.val);
            if (t.right != null) inorderTraversalHelper(t.right, traversal);
        }
    }

    // TODO post-order binary tree traversal (iterative)
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();

        return traversal;
    }

    // post-order binary tree traversal (recursive)
    public List<Integer> postorderTraversalRecursive(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        postorderTraversalHelper(root, traversal);

        return traversal;
    }

    private void postorderTraversalHelper(TreeNode t, List<Integer> traversal) {
        if (t != null) {
            if (t.left != null) postorderTraversalHelper(t.left, traversal);
            if (t.right != null) postorderTraversalHelper(t.right, traversal);
            traversal.add(t.val);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        TreeTraversal t = new TreeTraversal();

        System.out.println("preorderTraversal: " + t.preorderTraversal(root));
        System.out.println("preorderTraversalRecursive:" + t.preorderTraversalRecursive(root));

        System.out.println("inorderTraversal: " + t.inorderTraversal(root));
        System.out.println("inorderTraversalRecursive: " + t.inorderTraversalRecursive(root));

        System.out.println("postorderTraversal: " + t.postorderTraversal(root));
        System.out.println("postorderTraversalRecursive:" + t.postorderTraversalRecursive(root));
    }

}
