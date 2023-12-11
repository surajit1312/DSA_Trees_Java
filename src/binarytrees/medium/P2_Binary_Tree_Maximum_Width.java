package binarytrees.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 *
 * CodingNinjas: Maximum Width In Binary Tree
 *
 * Link:
 *
 * https://www.codingninjas.com/studio/problems/maximum-width-in-binary-tree_763671
 *
 * TC: O(n)
 * SC: O(n)
 *
 */
public class P2_Binary_Tree_Maximum_Width {

  static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
      this.val = val;
      this.left = null;
      this.right = null;
    }
  }

  static class Pair {

    TreeNode node;
    int level;

    Pair(TreeNode node, int level) {
      this.node = node;
      this.level = level;
    }
  }

  public static void main(String[] args) {
    int[] nums = { 1, 2, 3, 4, -1, 5, 6, -1, 7, -1, -1, -1, -1, -1, -1 };
    TreeNode root = createTree(nums, 0);
    System.out.println(root);
    int maxWidth = getMaxWidth(root);
    System.out.println("Maximum width of Binary Tree : " + maxWidth);
  }

  private static TreeNode createTree(int[] arr, int index) {
    TreeNode root = null;
    if (index < arr.length - 1 && arr[index] != -1) {
      root = new TreeNode(arr[index]);
      root.left = createTree(arr, 2 * index + 1);
      root.right = createTree(arr, 2 * index + 2);
    }
    return root;
  }

  private static int getMaxWidth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int maxWidth = 0;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    Queue<Pair> queue = new LinkedList<Pair>();
    queue.offer(new Pair(root, 0));
    while (!queue.isEmpty()) {
      Pair currPair = queue.poll();
      TreeNode currNode = currPair.node;
      int level = currPair.level;
      if (!map.containsKey(level)) {
        map.put(level, 0);
      }
      map.put(level, map.get(level) + 1);
      if (currNode.left != null) queue.offer(
        new Pair(currNode.left, level + 1)
      );
      if (currNode.right != null) queue.offer(
        new Pair(currNode.right, level + 1)
      );
    }
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      maxWidth = Math.max(maxWidth, entry.getValue());
    }
    return maxWidth;
  }
}
