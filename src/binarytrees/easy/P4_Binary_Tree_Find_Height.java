package binarytrees.easy;

/**
 * CodingNinjas:  Height of Binary Tree
 *
 * Link:
 *
 * https://www.codingninjas.com/studio/problems/height-of-binary-tree_4609628
 *
 * TC: O(n)
 * SC: O(1)
 *
 */
public class P4_Binary_Tree_Find_Height {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 5, 3, -1, -1, -1, -1, -1, -1};
        TreeNode root = createBinaryTree(nums, 0);
        System.out.println(root);
        int height = heightOfBinaryTree(root);
        System.out.println("Height of Binary Tree : " + height);
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

    public static int heightOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(heightOfBinaryTree(root.left), heightOfBinaryTree(root.right)) + 1;
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
