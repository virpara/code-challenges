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

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(4);
//        root.right = new TreeNode(2);
//        root.right.left = new TreeNode(3);

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        TreeTraversal t = new TreeTraversal();

        System.out.println("preorderTraversalIterative: " + t.preorderTraversalIterative(root));
        System.out.println("preorderTraversalRecursive:" + t.preorderTraversalRecursive(root));

        System.out.println("inorderTraversalInterative: " + t.inorderTraversalIterative(root));
        System.out.println("inorderTraversalRecursive: " + t.inorderTraversalRecursive(root));

        System.out.println("postorderTraversalIterative: " + t.postorderTraversalIterative(root));
        System.out.println("postorderTraversalRecursive:" + t.postorderTraversalRecursive(root));

        System.out.println("leverOrderRecursive: " + t.levelOrderRecursive(root));
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

    // pre-order binary tree traversal (iterative)
    public List<Integer> preorderTraversalIterative(TreeNode root) {
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

    // TODO in-order binary tree traversal (iterative)
    public List<Integer> inorderTraversalIterative(TreeNode root) {
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

    // TODO post-order binary tree traversal (iterative)
    public List<Integer> postorderTraversalIterative(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();

        return traversal;
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

    // level order (BSF) traversal recursive
    // returns list having a list of elements in level
    private List<List<Integer>> levelOrderRecursive(TreeNode root) {
        List<List<Integer>> ls = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if (root != null)
            q.add(root);


        List<List<Integer>> levels = new ArrayList<>();

        while (q.size() > 0) {

            int count = q.size();
            List<Integer> l = new ArrayList<>();

            for (int i = 0; i < count; i++) {
                TreeNode tmp = q.remove();

                l.add(tmp.val);

                if (tmp.left != null)
                    q.add(tmp.left);

                if (tmp.right != null)
                    q.add(tmp.right);

            }

            levels.add(l);

        }

        return levels;
    }
}
