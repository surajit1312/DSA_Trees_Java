package binarytrees.medium;

import java.util.*;

/**
 *
 * CodingNinjas: Spiral Order Traversal of a Binary Tree
 *
 * Link:
 *
 * https://www.codingninjas.com/studio/problems/spiral-order-traversal-of-a-binary-tree_630521
 *
 * TC: O(n)
 * SC: O(n)
 *
 */
public class P1_Binary_Tree_Spiral_Order_Traversal {

  /**
   * @param args
   */
  public static void main(String[] args) {
    int[] nums = { 1, 2, 3, 4, -1, 5, 6, -1, 7, -1, -1, -1, -1, -1, -1 };
    BinaryTreeNode root = createBinaryTree(nums, 0);
    System.out.println(root);
    ArrayList<Integer> spiralPath = spiralOrder(root);
    System.out.println("Spiral Order Traversal of Binary Tree : " + spiralPath);
  }

  private static BinaryTreeNode createBinaryTree(int[] arr, int index) {
    BinaryTreeNode root = null;
    if (index <= arr.length - 1 && arr[index] != -1) {
      root = new BinaryTreeNode(arr[index]);
      root.left = createBinaryTree(arr, 2 * index + 1);
      root.right = createBinaryTree(arr, 2 * index + 2);
    }
    return root;
  }

  public static ArrayList<Integer> spiralOrder(BinaryTreeNode root) {
    if (root == null) {
      return new ArrayList<Integer>();
    }
    ArrayList<Integer> path = new ArrayList<Integer>();
    Queue<Pair> queue = new LinkedList<Pair>();
    queue.offer(new Pair(root, 0));
    Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();

    while (!queue.isEmpty()) {
      Pair currentPair = queue.poll();
      int level = currentPair.level;
      BinaryTreeNode currentNode = currentPair.node;
      if (!map.containsKey(level)) {
        map.put(level, new ArrayList<Integer>());
      }
      if (level % 2 == 0) {
        // for even levels append to arraylist
        map.get(level).add(currentNode.data);
      } else {
        // for odd levels add to beginning of arraylist
        map.get(level).add(0, currentNode.data);
      }
      if (currentNode.left != null) queue.offer(
        new Pair(currentNode.left, level + 1)
      );
      if (currentNode.right != null) queue.offer(
        new Pair(currentNode.right, level + 1)
      );
    }
    for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
      for (Integer it : entry.getValue()) {
        path.add(it);
      }
    }
    return path;
  }

  static class Pair {

    BinaryTreeNode node;
    int level;

    public Pair(BinaryTreeNode node, int level) {
      this.node = node;
      this.level = level;
    }
  }

  static class BinaryTreeNode {

    int data;
    BinaryTreeNode left;
    BinaryTreeNode right;

    BinaryTreeNode() {
      this.data = 0;
      this.left = null;
      this.right = null;
    }

    BinaryTreeNode(int data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }

    BinaryTreeNode(int data, BinaryTreeNode left, BinaryTreeNode right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }
}
