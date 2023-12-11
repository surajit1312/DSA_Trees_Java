package binarytrees.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * CodingNinjas: Nodes In Complete Binary Tree
 *
 * Link:
 *
 * https://www.codingninjas.com/studio/problems/nodes-in-complete-binary-tree_1281151
 *
 * TC: O(n)
 * SC: O(n)
 *
 */
public class P3_Complete_Binary_Tree_Count_Nodes {

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
    int[] nums = { 1, 2, 3, 4, -1, 5, 6, -1, 7, -1, -1, -1, -1 };
    BinaryTreeNode root = createTree(nums, 0);
    System.out.println(root);
    int numNodes = countNodes(root);
    System.out.println("Number of nodes in complete Binary Tree : " + numNodes);
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

  private static int countNodes(BinaryTreeNode root) {
    if (root == null) {
      return 0;
    }
    int count = 0;
    Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      BinaryTreeNode current = queue.poll();
      count++;
      if (current.left != null) queue.offer(current.left);
      if (current.right != null) queue.offer(current.right);
    }
    return count;
  }
}
