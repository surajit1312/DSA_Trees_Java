package binarytrees.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * CodingNinjas: All Root to Leaf Paths In Binary Tree
 * 
 * Link:
 * https://www.codingninjas.com/studio/problems/all-root-to-leaf-paths-in-binary-tree._983599
 * 
 * TC: O(N)
 * SC: O(N)
 * 
 */
public class P14_All_Root_To_Leaf_Paths_Binary_Tree {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1 };
        BinaryTreeNode root = createTree(arr, 0);
        List<String> allPaths = allRootToLeaf(root);
        System.out.println("All paths from root to leaf of Binary Tree are : " + allPaths);
    }

    public static List<String> allRootToLeaf(BinaryTreeNode root) {
        List<String> allPaths = new ArrayList<String>();
        traversalPath(root, allPaths, "");
        return allPaths;
    }

    private static void traversalPath(BinaryTreeNode node, List<String> paths, String path) {
        if (node == null) {
            return;
        }
        path += path == "" ? node.data : " " + node.data;
        if (node.left == null && node.right == null) {
            paths.add(path);
        }
        traversalPath(node.left, paths, path);
        traversalPath(node.right, paths, path);
    }

    private static BinaryTreeNode createTree(int[] arr, int index) {
        BinaryTreeNode root = null;
        if (index < arr.length) {
            root = arr[index] != -1 ? new BinaryTreeNode(arr[index]) : null;
            if (root != null) {
                root.left = createTree(arr, 2 * index + 1);
                root.right = createTree(arr, 2 * index + 2);
            }
        }
        return root;
    }

    static class BinaryTreeNode {
        int data;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}
