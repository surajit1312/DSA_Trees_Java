package binarytrees.medium;

/**
 * 
 * GeeksForGeeks: Lowest Common Ancestor in a Binary Tree
 * 
 * Link:
 * https://practice.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-binary-tree/1
 * 
 * TC: O(N) where N = number of nodes
 * SC: O(N) auxiliary space usedin recursion stack
 * 
 */
public class P10_LCA_Binary_Tree {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 7, -1, -1, -1, -1, -1, -1 };
        int x = 4;
        int y = 7;
        TreeNode root = createBinaryTree(arr, 0);
        int lcaNode = lowestCommonAncestor(root, x, y);
        System.out.println("Lowest Common Ancestor of Binary Tree is : " + lcaNode);
    }

    private static int lowestCommonAncestor(TreeNode root, int x, int y) {
        return findLCABinaryTree(root, x, y).data;
    }

    private static TreeNode findLCABinaryTree(TreeNode root, int x, int y) {
        if (root == null || root.data == x || root.data == y) {
            return root;
        }
        TreeNode leftTreeNode = findLCABinaryTree(root.left, x, y);
        TreeNode rightTreeNode = findLCABinaryTree(root.right, x, y);

        if (leftTreeNode == null) {
            return rightTreeNode;
        } else if (rightTreeNode == null) {
            return leftTreeNode;
        } else {
            return root;
        }
    }

    private static TreeNode createBinaryTree(int[] arr, int index) {
        TreeNode root = null;
        if (index <= arr.length - 1 && arr[index] != -1) {
            root = new TreeNode(arr[index]);
            root.left = createBinaryTree(arr, 2 * index + 1);
            root.right = createBinaryTree(arr, 2 * index + 2);
        }
        return root;
    }

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
}
