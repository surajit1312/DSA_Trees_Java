package binarysearchtrees.medium;

/**
 * 
 * CodingNinjas: Check BST
 * 
 * Link: https://www.codingninjas.com/studio/problems/check-bst_5975
 * 
 * TC: O(H), where H = height of tree
 * SC: O(1)
 * 
 */
public class P1_Check_If_Binary_Search_Tree {
    public static void main(String[] args) {
        int[] arr = { 4, 2, 6, 1, 3, 5, 7 };
        Node root = createBinaryTree(arr, 0);
        boolean isValidBST = isBST(root);
        System.out.println("Is Tree a valid BST : " + isValidBST);
    }

    private static boolean isBST(Node root) {
        return isValidBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isValidBinarySearchTree(Node node, int valueFrom, int valueTill) {
        if (node == null) {
            return true;
        }
        if (node.data <= valueFrom || node.data >= valueTill) {
            return false;
        }
        return isValidBinarySearchTree(node.left, valueFrom, node.data)
                && isValidBinarySearchTree(node.right, node.data, valueTill);
    }

    private static Node createBinaryTree(int[] arr, int index) {
        Node root = null;
        if (index <= arr.length - 1 && arr[index] != -1) {
            root = new Node(arr[index]);
            root.left = createBinaryTree(arr, 2 * index + 1);
            root.right = createBinaryTree(arr, 2 * index + 2);
        }
        return root;
    }

    static class Node {
        int data;
        Node left;
        Node right;

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
}
