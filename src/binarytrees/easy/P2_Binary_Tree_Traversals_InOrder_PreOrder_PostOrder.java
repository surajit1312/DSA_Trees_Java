/**
 * 
 */
package binarytrees.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * CodingNinjas: Tree Traversals
 * 
 * Link:
 * 
 * https://www.codingninjas.com/studio/problems/tree-traversal_981269
 * 
 * TC: O(n)
 * SC: O(n) - due to recursion stack
 * 
 */
public class P2_Binary_Tree_Traversals_InOrder_PreOrder_PostOrder {

	static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode() {
			this.data = 0;
			this.left = null;
			this.right = null;
		}

		TreeNode(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}

		TreeNode(int data, TreeNode left, TreeNode right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = { 1, 2, 4, 5, 3, -1, -1, -1, -1, -1, -1 };
		TreeNode root = createBinaryTree(nums, 0);
		System.out.println(root);
		List<List<Integer>> traversals = getTreeTraversal(root);
		System.out
				.println("Tree traversals for types InOrder, PreOrder and PostOrder looks like below respectively : ");
		System.out.println(traversals);
	}

	private static TreeNode createBinaryTree(int[] arr, int index) {
		TreeNode root = null;
		if (index <= arr.length - 1 && arr[index] != -1) {
			root = new TreeNode(arr[index]);
			root.left = createBinaryTree(arr, 2 * index + 1);
			root.right = createBinaryTree(arr, 2 * index + 2);
		}
		return root;
	}

	private static List<List<Integer>> getTreeTraversal(TreeNode root) {
		List<List<Integer>> traversals = new ArrayList<List<Integer>>();
		List<Integer> inorder = getInorderTraversal(root);
		traversals.add(inorder);
		List<Integer> preorder = getPreorderTraversal(root);
		traversals.add(preorder);
		List<Integer> postorder = getPostorderTraversal(root);
		traversals.add(postorder);
		return traversals;
	}

	private static List<Integer> getInorderTraversal(TreeNode root) {
		List<Integer> traversal = new ArrayList<Integer>();
		traversalHelper(root, traversal, "inorder");
		return traversal;
	}

	private static List<Integer> getPreorderTraversal(TreeNode root) {
		List<Integer> traversal = new ArrayList<Integer>();
		traversalHelper(root, traversal, "preorder");
		return traversal;
	}

	private static List<Integer> getPostorderTraversal(TreeNode root) {
		List<Integer> traversal = new ArrayList<Integer>();
		traversalHelper(root, traversal, "postorder");
		return traversal;
	}

	private static void traversalHelper(TreeNode root, List<Integer> traversal, String type) {
		if (root == null) {
			return;
		}
		if (type == "inorder") {
			// Inorder Traversal - LNR
			traversalHelper(root.left, traversal, type);
			traversal.add(root.data);
			traversalHelper(root.right, traversal, type);
		} else if (type == "preorder") {
			// Preorder Traversal - NLR
			traversal.add(root.data);
			traversalHelper(root.left, traversal, type);
			traversalHelper(root.right, traversal, type);
		} else {
			// Preorder Traversal - LRN
			traversalHelper(root.left, traversal, type);
			traversalHelper(root.right, traversal, type);
			traversal.add(root.data);
		}
	}

}
