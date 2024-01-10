package binarytrees.medium;

/**
 * 
 * CodingNinjas: Symmetrical Binary Tree
 * 
 * Link: https://www.codingninjas.com/studio/problems/symmetric-tree_981177
 * 
 * TC: O(N)
 * SC: O(N)
 * 
 */
public class P13_Symmetrical_Binary_Tree {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 3, 4, 4, 3, -1, -1, -1, -1, -1, -1, -1, -1 };
        TreeNode root = createTree(arr, 0);
        boolean isTreeSymmetric = isSymmetric(root);
        System.out.println("Is Binary Tree symmetric : " + isTreeSymmetric);
    }

    private static boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetricHelper(root.left, root.right);
    }

    private static boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }
        return left.data == right.data && isSymmetricHelper(left.left, right.right)
                && isSymmetricHelper(left.right, right.left);
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
