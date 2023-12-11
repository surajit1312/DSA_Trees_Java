package binarytrees.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 *
 * CodingNinjas: Left View Of a Binary Tree
 *
 * Link:
 *
 * https://www.codingninjas.com/studio/problems/left-view-of-a-binary-tree_920519
 *
 * TC: O(n)
 * SC: O(n)
 *
 */
public class P4_Binary_Tree_Left_View {

  static class TreeNode {

    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
      this.data = data;
      left = null;
      right = null;
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
    int[] nums = { 2, 8, 7, -1, 5, -1, -1, 1, -1, -1, -1 };
    TreeNode root = createTree(nums, 0);
    System.out.println(root);
    ArrayList<Integer> leftView = getLeftView(root);
    System.out.println("Left View of Binary Tree : " + leftView);
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

  public static ArrayList<Integer> getLeftView(TreeNode root) {
    if (root == null) {
      return new ArrayList<Integer>();
    }
    ArrayList<Integer> view = new ArrayList<Integer>();
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    Queue<Pair> queue = new LinkedList<Pair>();
    queue.offer(new Pair(root, 0));

    while (!queue.isEmpty()) {
      Pair currPair = queue.poll();
      if (!map.containsKey(currPair.level)) {
        map.put(currPair.level, (Integer) currPair.node.data);
      }
      if (currPair.node.left != null) queue.offer(
        new Pair(currPair.node.left, currPair.level + 1)
      );
      if (currPair.node.right != null) queue.offer(
        new Pair(currPair.node.right, currPair.level + 1)
      );
    }

    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      view.add(entry.getValue());
    }
    return view;
  }
}
