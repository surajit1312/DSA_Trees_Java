package binarytrees.medium;

/**
 *
 * GeeksForGeeks: Check for Balanced Tree
 *
 * Link: https://www.geeksforgeeks.org/problems/check-for-balanced-tree/1
 *
 * TC: O(n)
 * SC: O(h) where h = height of Binary Tree
 *
 */
public class P8_Binary_Tree_Find_If_Balanced {

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

    public boolean balanced;
    public int height;

    TreePair(boolean balanced, int height) {
      this.balanced = balanced;
      this.height = height;
    }
  }

  public static void main(String[] args) {
    int[] nums = { 1, 2, 3, 4, -1, -1, 5, -1, -1, -1, -1 };
    TreeNode root = createTree(nums, 0);
    System.out.println(root);
    boolean isBalanced = isBalancedBT(root);
    System.out.println("Is Binary Tree balanced : " + isBalanced);
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

  private static boolean isBalancedBT(TreeNode root) {
    return balancedHelper(root).balanced;
  }

  private static TreePair balancedHelper(TreeNode root) {
    if (root == null) {
      return new TreePair(true, 0);
    }
    TreePair lPair = balancedHelper(root.left);
    TreePair rPair = balancedHelper(root.right);

    boolean lBalanced = lPair.balanced;
    boolean rBalanced = rPair.balanced;
    boolean treeBalanced = Math.abs(lPair.height - rPair.height) <= 1;
    int height = Math.max(lPair.height, rPair.height) + 1;

    return new TreePair(lBalanced && rBalanced && treeBalanced, height);
  }
}
