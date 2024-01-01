package binarysearchtrees.medium;

/**
 * 
 * CodingNinjas: LCA of Two Nodes In A BST
 * 
 * Link: https://www.codingninjas.com/studio/problems/lca-in-a-bst_981280
 * 
 * TC: O(H), where H is the height of Tree
 * SC: O(1)
 * 
 */
public class P2_LCA_In_Binary_Search_Tree {

    public static void main(String[] args) {
        int[] arr = { 5, 4, 6, 3, -1, -1, 7, -1, -1, -1, -1, -1, -1, -1, 8 };
        TreeNode p = new TreeNode(7);
        TreeNode q = new TreeNode(8);
        TreeNode root = createBinaryTree(arr, 0);
        TreeNode lcaNode = findLCAInBST(root, p, q);
        System.out.println("The Lowest Common Ancestor in BST is " + lcaNode.data);
    }

    private static TreeNode findLCAInBST(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        TreeNode currentNode = root;
        if (p.data < currentNode.data && q.data < currentNode.data) {
            return findLCAInBST(currentNode.left, p, q);
        }
        if (p.data > currentNode.data && q.data > currentNode.data) {
            return findLCAInBST(currentNode.right, p, q);
        }
        return currentNode;
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
}
