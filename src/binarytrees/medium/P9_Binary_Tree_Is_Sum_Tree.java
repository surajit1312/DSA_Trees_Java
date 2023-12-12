package binarytrees.medium;

/**
 *
 * CodingNinjas: Check If Binary Tree Is Sum Tree Or Not
 *
 * Link: https://www.codingninjas.com/studio/problems/check-if-binary-tree-is-sum-tree-or-not_1164404
 *
 * TC: O(n)
 * SC: O(h), where h = height of Binary Tree (in worst case h = n in case if Tree is a Skewed Tree or a LinkedList)
 *
 */
public class P9_Binary_Tree_Is_Sum_Tree {

  static class TreeNode {

    public int data;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int data) {
      this.data = data;
      left = null;
      right = null;
    }
  }

  static class TreePair {

    public boolean validSumTree;
    public int sum;

    TreePair(boolean validSumTree, int sum) {
      this.validSumTree = validSumTree;
      this.sum = sum;
    }
  }

  public static void main(String[] args) {
    int[] nums = { 3, 1, 2, -1, -1, -1, -1 };
    TreeNode root = createTree(nums, 0);
    System.out.println(root);
    boolean isSumBT = isSumTree(root);
    System.out.println("Is Binary Tree a Sum Tree : " + isSumBT);
  }

  private static TreeNode createTree(int[] arr, int index) {
    TreeNode root = null;
    if (index < arr.length - 1) {
      root = arr[index] != -1 ? new TreeNode(arr[index]) : null;
      if (root != null) {
        root.left = createTree(arr, 2 * index + 1);
        root.right = createTree(arr, 2 * index + 2);
      }
    }
    return root;
  }

  private static boolean isSumTree(TreeNode root) {
    return isSumTreeHelper(root).validSumTree;
  }

  private static TreePair isSumTreeHelper(TreeNode root) {
    if (root == null) {
      return new TreePair(true, 0);
    }
    if (root.left == null && root.right == null) {
      return new TreePair(true, root.data);
    }
    TreePair lPair = isSumTreeHelper(root.left);
    TreePair rPair = isSumTreeHelper(root.right);

    boolean lValid = lPair.validSumTree;
    boolean rValid = rPair.validSumTree;
    int sum = lPair.sum + rPair.sum;
    boolean currentValid = lValid && rValid && root.data == sum;
    return new TreePair(currentValid, root.data + sum);
  }
}
