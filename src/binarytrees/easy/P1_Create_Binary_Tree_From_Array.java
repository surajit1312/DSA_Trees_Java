/**
 * 
 */
package binarytrees.easy;

/**
 * 
 * CodingNinjas: Create Binary Tree
 * Link: https://www.codingninjas.com/studio/problems/create-binary-tree_8360671
 * 
 * TC: O(n)
 * SC: O(n) - due to recursion stack
 */
public class P1_Create_Binary_Tree_From_Array {

	static class Node {
		public int data;
		public Node left;
		public Node right;

		Node() {
			this.data = 0;
			this.left = null;
			this.right = null;
		}

		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}

		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = { 11, 22, 3, 54, 15, 23, 21 };
		Node treeNode = createTree(nums);
		System.out.println(treeNode);
	}

	private static Node createTree(int[] arr) {
		Node root = createTreeHelper(arr, 0);
		return root;
	}

	private static Node createTreeHelper(int[] arr, int index) {
		Node root = null;
		if (index <= arr.length - 1) {
			root = new Node(arr[index]);
			root.left = createTreeHelper(arr, 2 * index + 1);
			root.right = createTreeHelper(arr, 2 * index + 2);
		}
		return root;
	}

}
