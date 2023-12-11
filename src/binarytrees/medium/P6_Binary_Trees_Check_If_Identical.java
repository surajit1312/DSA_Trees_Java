package binarytrees.medium;

/**
 *
 * CodingNinjas: Check Identical Trees
 *
 * Link:
 *
 * https://www.codingninjas.com/studio/problems/check-identical-trees_799364
 *
 * TC: O(n)
 * SC: O(n)
 *
 */
public class P6_Binary_Trees_Check_If_Identical {

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
    int[] nums = { 5, 2, 3, -1, 6, -1, -1, -1, -1 };
    BinaryTreeNode root1 = createTree(nums, 0);
    BinaryTreeNode root2 = createTree(nums, 0);
    boolean isIdentical = identicalTrees(root1, root2);
    System.out.println("Binary Trees are identical : " + isIdentical);
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

  public static boolean identicalTrees(
    BinaryTreeNode root1,
    BinaryTreeNode root2
  ) {
    if (root1 == null || root2 == null) {
      return root1 == root2;
    }
    return (
      root1.data == root2.data &&
      identicalTrees(root1.left, root2.left) &&
      identicalTrees(root1.right, root2.right)
    );
  }
}
