package binarytrees.medium;

import java.util.ArrayList;

/**
 * 
 * CodingNinjas:
 * 
 * Link: https://www.codingninjas.com/studio/problems/right-view_764605
 * 
 * TC: O(n)
 * SC: O(log(n))
 */
public class P5_Binary_Tree_Right_View {

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
    int[] nums = { 2, 35, 10, 2, 3, 5, 2, -1, -1, -1, -1, -1, -1, -1, -1 };
    BinaryTreeNode root = createTree(nums, 0);
    System.out.println(root);
    ArrayList<Integer> view = printRightView(root);
    System.out.println(view);
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

  private static ArrayList<Integer> printRightView(BinaryTreeNode root) {
    if (root == null) {
      return new ArrayList<Integer>();
    }
    ArrayList<Integer> view = new ArrayList<Integer>();
    getRightViewHelper(root, 0, view);
    return view;
  }

  private static void getRightViewHelper(
    BinaryTreeNode root,
    int level,
    ArrayList<Integer> view
  ) {
    if (view.size() == level) {
      view.add(root.data);
    }
    if (root.right != null) {
      getRightViewHelper(root.right, level + 1, view);
    }
    if (root.left != null) {
      getRightViewHelper(root.left, level + 1, view);
    }
  }
}
