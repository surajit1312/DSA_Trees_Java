package binarytrees.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * CodingNinjas: Boundary Traversal of Binary Tree
 * 
 * Link:
 * https://www.codingninjas.com/studio/problems/boundary-traversal-of-binary-tree_790725
 * 
 * TC: O(H) + O(H) + O(N) ~ O(N), where H = Height of tree
 * SC: O(L) where L = Number of Leaf nodes ~ O(N) in case of skewed Tree
 * 
 */
public class P1_Boundary_Traversal_Binary_Tree {
    public static void main(String[] args) {
        int[] arr = { 100, 50, 150, 25, 75, 140, 200, -1, 30, 70, 80, -1, -1, -1, -1, -1, -1, -1, 35, -1, -1, -1, -1,
                -1, -1 };
        TreeNode root = createTree(arr, 0);
        List<Integer> boundary = traverseBoundary(root);
        System.out.println("Boundary Traversal path of Binary Tree is : " + boundary);
    }

    private static List<Integer> traverseBoundary(TreeNode root) {
        List<Integer> traversalPath = new ArrayList<Integer>();
        if (root == null) {
            return traversalPath;
        }
        traversalPath.add(root.data);
        if (isLeafNode(root)) {
            return traversalPath;
        }
        leftTreeTraverse(root, traversalPath);
        leafNodeTraverse(root, traversalPath);
        rightTreeTraverse(root, traversalPath);
        return traversalPath;
    }

    private static boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }

    private static void leftTreeTraverse(TreeNode node, List<Integer> traversal) {
        TreeNode currentNode = node.left;
        while (currentNode != null) {
            if (!isLeafNode(currentNode)) {
                traversal.add(currentNode.data);
            }
            if (currentNode.left != null) {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
        }
    }

    private static void leafNodeTraverse(TreeNode node, List<Integer> traversal) {
        TreeNode currentNode = node;
        if (isLeafNode(currentNode)) {
            traversal.add(currentNode.data);
            return;
        }
        if (currentNode.left != null) {
            leafNodeTraverse(currentNode.left, traversal);
        }
        if (currentNode.right != null) {
            leafNodeTraverse(currentNode.right, traversal);
        }
    }

    private static void rightTreeTraverse(TreeNode node, List<Integer> traversal) {
        TreeNode currentNode = node.right;
        Stack<Integer> stack = new Stack<Integer>();
        while (currentNode != null) {
            if (!isLeafNode(currentNode)) {
                stack.add(currentNode.data);
            }
            if (currentNode.right != null) {
                currentNode = currentNode.right;
            } else {
                currentNode = currentNode.left;
            }
        }
        while (!stack.isEmpty()) {
            traversal.add(stack.pop());
        }
    }

    private static TreeNode createTree(int[] arr, int index) {
        TreeNode root = null;
        if (index < arr.length) {
            root = arr[index] != -1 ? new TreeNode(arr[index]) : null;
            if (root != null) {
                root.left = createTree(arr, 2 * index + 1);
                root.right = createTree(arr, 2 * index + 2);
            }
        }
        return root;
    }

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}
