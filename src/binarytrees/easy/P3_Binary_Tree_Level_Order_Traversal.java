/**
 * 
 */
package binarytrees.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * CodingNinjas: Level Order Traversal
 * 
 * Link:
 * 
 * https://www.codingninjas.com/studio/problems/level-order-traversal_796002
 * 
 * TC: O(n)
 * SC: O(n)
 * 
 */
public class P3_Binary_Tree_Level_Order_Traversal {

	static class BinaryTreeNode<T> {
		T val;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = { 2, 7, 5, 2, 6, -1, 9, -1, -1, 5, 11, 4, -1, -1, -1, -1, -1, -1, -1 };
		BinaryTreeNode<Integer> root = createBinaryTree(nums, 0);
		System.out.println(root);
		ArrayList<Integer> levelOrderTraversal = getLevelOrder(root);
		System.out.println("Level Order Traversal Data : " + levelOrderTraversal);
	}

	private static BinaryTreeNode<Integer> createBinaryTree(int[] arr, int index) {
		BinaryTreeNode<Integer> root = null;
		if (index <= arr.length - 1) {
			root = arr[index] == -1 ? null : new BinaryTreeNode<Integer>(arr[index]);
			if (root != null) {
				root.left = createBinaryTree(arr, 2 * index + 1);
				root.right = createBinaryTree(arr, 2 * index + 2);
			}
		}
		return root;
	}

	private static ArrayList<Integer> getLevelOrder(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return new ArrayList<Integer>();
		}
		ArrayList<Integer> traversal = new ArrayList<Integer>();
		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<BinaryTreeNode<Integer>>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			BinaryTreeNode<Integer> current = queue.poll();
			traversal.add(current.val);
			if (current.left != null) {
				queue.offer(current.left);
			}
			if (current.right != null) {
				queue.offer(current.right);
			}
		}
		return traversal;
	}

}
