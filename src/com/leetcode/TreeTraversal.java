package com.leetcode;

import java.math.BigDecimal;
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

    // level order (BSF) traversal
    // returns list having a list of elements in level
    private List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ls = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if (root != null)
            q.add(root);


        List<Integer> level = new ArrayList<>();

        while (q.size() > 0) {
            TreeNode tmp = q.remove();

            level.add(tmp.val);

            if (tmp.left != null) q.add(tmp.left);
            if (tmp.right != null) q.add(tmp.right);
        }

        // add dummy value at index 0,
        // to access same level elements from array using i < 2 ^ i
        level.add(0, 0);

        Integer[] array = level.toArray(new Integer[0]);

        List<Integer> l = new ArrayList<>();
        int pow = 1;
        int lvl = (int) Math.pow(2, pow++);
        for (int i = 1; i < array.length; i++) {

            if (i == lvl) {
                lvl = (int) Math.pow(2, pow++);
                ls.add(l);

                l = new ArrayList<>(); // new list for each level
            }

            l.add(array[i]);

            // add the last level if array size < 2 ^ pow
            if (i == array.length - 1) {
                ls.add(l);
            }
        }

        return ls;
    }

//    /**
//     * we assume the node exists in the tree.
//     * @param root root node of a bst tree
//     * @param node find the height of node
//     * @return the height of the node from root node(number of vertices between root and node).
//     */
//    private int height(TreeNode root, TreeNode node) {
//        int findHeightFor = node.val;
//        int height = -1;
//
//        TreeNode tmp = root;
//        while (tmp != null) {
//            height++;
//            if (findHeightFor < tmp.val) {
//                tmp = tmp.left;
//            } else if (findHeightFor > tmp.val) {
//                tmp = tmp.right;
//            } else {
//                break;
//            }
//        }
//
//        return height;
//    }

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

        System.out.println("leverOrder: " + t.levelOrder(root));
    }

}
