package binarysearchtrees.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * CodingNinjas: Kth smallest node in BST
 * 
 * Link:
 * 1.
 * https://www.codingninjas.com/studio/problems/kth-smallest-node-in-bst_920441
 * 2.
 * https://www.geeksforgeeks.org/problems/kth-largest-element-in-bst/1
 * 
 * TC: O(N)
 * SC: O(N)
 * 
 */
public class P4_Kth_Smallest_Node_Binary_Search_Tree {
    public static void main(String[] args) {
        int[] arr = { 10, 5, 15, 4, 7, 14, 16, -1, -1, -1, -1, -1, -1, -1, -1 };
        int k = 3;
        TreeNode root = createBinaryTree(arr, 0);
        int kthSmallestElement = kthSmallest(root, k);
        System.out.println("Kth smallest element in BST : " + kthSmallestElement);
    }

    public static int kthSmallest(TreeNode root, int k) {
        List<Integer> traversal = new ArrayList<Integer>();
        inOrderTraversal(root, k, traversal);
        System.out.println(traversal);
        return traversal.get(k - 1);
    }

    /**
     * InOrder Traversal - Left Node Right
     * 
     * @param root
     * @param k
     */
    private static void inOrderTraversal(TreeNode root, int k, List<Integer> traversal) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left, k, traversal);
        traversal.add(root.data);
        inOrderTraversal(root.right, k, traversal);
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

        TreeNode() {
            this.data = 0;
            this.left = null;
            this.right = null;
        }

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
