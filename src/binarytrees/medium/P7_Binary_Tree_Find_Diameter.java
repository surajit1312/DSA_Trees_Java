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

  static class TreePair {

    public int diameter;
    public int height;

    TreePair(int diameter, int height) {
      this.diameter = diameter;
      this.height = height;
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
    TreePair pair = diameterBinaryTreeHelper(root);
    return pair.diameter;
  }

  private static TreePair diameterBinaryTreeHelper(BinaryTreeNode root) {
    if (root == null) {
      return new TreePair(0, 0);
    }
    TreePair lPair = diameterBinaryTreeHelper(root.left);
    TreePair rPair = diameterBinaryTreeHelper(root.right);

    int diaOp1 = lPair.diameter;
    int diaOp2 = rPair.diameter;
    int diaOp3 = lPair.height + rPair.height + 1;
    int maxDiameter = Math.max(diaOp1, Math.max(diaOp2, diaOp3));
    int maxHeight = Math.max(lPair.height, rPair.height) + 1;
    return new TreePair(maxDiameter, maxHeight);
  }
}
