package com.leetcode;

import java.util.*;

public class TreeTraversal {

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

        System.out.println("leverOrderIterative: " + t.levelOrderIterative(root));
    }

    // pre-order binary tree traversal (iterative)
    public List<Integer> preorderTraversalIterative(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();

        Deque<TreeNode> stk = new ArrayDeque<TreeNode>();

        if (root != null) stk.push(root);
        while (!stk.isEmpty()) {
            TreeNode tmp = stk.pop();
            if (tmp != null) {
                traversal.add(tmp.val);
                if (tmp.right != null) stk.push(tmp.right);

                if (tmp.left != null) stk.push(tmp.left);
            }
        }

        return traversal;
    }

    public List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        Deque<Pair> stk = new ArrayDeque<>();
        var rp = new Pair(root, 1);
        stk.push(rp);

        while (!stk.isEmpty()) {
            var top = stk.peek();

            switch (top.state) {
                case 1:
                    top.state = top.state + 1;

                    if (top.node.left != null) {
                        var left = new Pair(top.node.left, 1);
                        stk.push(left);
                    }
                    break;
                case 2:
                    traversal.add(top.node.val);
                    top.state = top.state + 1;

                    if (top.node.right != null) {
                        var right = new Pair(top.node.right, 1);
                        stk.push(right);
                    }
                    break;
                case 3:
                    stk.pop();
                    break;
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

    public List<Integer> postorderTraversalIterative(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        Deque<Pair> stk = new ArrayDeque<>();
        var rp = new Pair(root, 1);
        stk.push(rp);

        while (!stk.isEmpty()) {
            var top = stk.peek();

            switch (top.state) {
                case 1:
                    top.state = top.state + 1;

                    if (top.node.left != null) {
                        var left = new Pair(top.node.left, 1);
                        stk.push(left);
                    }
                    break;
                case 2:
                    top.state = top.state + 1;

                    if (top.node.right != null) {
                        var right = new Pair(top.node.right, 1);
                        stk.push(right);
                    }
                    break;
                case 3:
                    traversal.add(top.node.val);
                    stk.pop();
                    break;
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

    private static class Pair {
        TreeTraversal.TreeNode node;
        int state;

        public Pair(TreeTraversal.TreeNode node, int state) {
            this.node = node;
            this.state = state;
        }
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

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TreeNode treeNode = (TreeNode) o;
            return val == treeNode.val && Objects.equals(left, treeNode.left) && Objects.equals(right, treeNode.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, left, right);
        }
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

    // level order (BSF) traversal iterative
    // returns list having a list of elements in level
    private List<List<Integer>> levelOrderIterative(TreeNode root) {
        List<List<Integer>> ls = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if (root != null)
            q.add(root);


        List<List<Integer>> levels = new ArrayList<>();

        while (!q.isEmpty()) {

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
