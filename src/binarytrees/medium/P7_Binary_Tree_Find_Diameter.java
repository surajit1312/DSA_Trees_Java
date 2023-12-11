package binarytrees.medium;

/**
 *
 * CodingNinjas:  Diameter Of Binary Tree
 *
 * Link:
 *
 * https://www.codingninjas.com/studio/problems/find-diameter_5205
 *
 * TC: O(n)
 * SC: O(h) + O(1) where h = height of Binary Tree
 *
 */
public class P7_Binary_Tree_Find_Diameter {

  static class BinaryTreeNode {

    public int data;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    BinaryTreeNode(int data) {
      this.data = data;
      left = null;
      right = null;
    }
  }

  public static void main(String[] args) {
    int[] nums = {
      2,
      4,
      5,
      6,
      -1,
      -1,
      7,
      20,
      30,
      80,
      90,
      -1,
      -1,
      8,
      -1,
      -1,
      9,
      -1,
      -1,
      -1,
      -1,
      -1,
      -1,
    };
    BinaryTreeNode root = createTree(nums, 0);
    System.out.println(root);
    int diameter = diameterOfBinaryTree(root);
    System.out.println("Diameter of Binary Tree : " + diameter);
  }

  private static BinaryTreeNode createTree(int[] arr, int index) {
    BinaryTreeNode root = null;
    if (index < arr.length - 1) {
      root = arr[index] != -1 ? new BinaryTreeNode(arr[index]) : null;
      if (root != null) {
        root.left = createTree(arr, 2 * index + 1);
        root.right = createTree(arr, 2 * index + 2);
      }
    }
    return root;
  }

  private static int diameterOfBinaryTree(BinaryTreeNode root) {
    int[] diameter = new int[1];
    diameter[0] = Integer.MIN_VALUE;
    diameterBinaryTreeHelper(root, diameter);
    return diameter[0] + 1;
  }

  private static int diameterBinaryTreeHelper(BinaryTreeNode root, int[] max) {
    if (root == null) {
      return 0;
    }
    int lh = diameterBinaryTreeHelper(root.left, max);
    int rh = diameterBinaryTreeHelper(root.right, max);
    max[0] = Math.max(max[0], lh + rh);
    return Math.max(lh, rh) + 1;
  }
}
