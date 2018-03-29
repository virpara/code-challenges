package com.leetcode;

import java.util.*;

public class TreeTraversal {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // preorder traversal iterative version
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

    public static void main(String[] args) {

    }

}
