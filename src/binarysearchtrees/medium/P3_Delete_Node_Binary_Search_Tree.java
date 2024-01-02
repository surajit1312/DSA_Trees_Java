package binarysearchtrees.medium;

/**
 * 
 * GeeksForGeeks: Delete a node from BST
 * 
 * Link: https://www.geeksforgeeks.org/problems/delete-a-node-from-bst/1
 * 
 * TC: O(N)
 * SC: O(N)
 */
public class P3_Delete_Node_Binary_Search_Tree {
    public static void main(String[] args) {
        int[] arr = { 15, 10, 20, 8, 12, 16, 25, -1, -1, -1, -1, -1, -1, -1, -1 };
        int key = 10;
        BinaryTreeNode root = createBinaryTree(arr, 0);
        BinaryTreeNode modifiedRoot = deleteNode(root, key);
        System.out.println("Modified Tree : " + modifiedRoot);
    }

    private static BinaryTreeNode deleteNode(BinaryTreeNode root, int key) {
        if (root == null) {
            return null;
        }
        BinaryTreeNode parentKeyNode = getParentKeyNode(root, key);
        if (parentKeyNode == null) {
            return null;
        }
        BinaryTreeNode targetNode = parentKeyNode.left.data == key ? parentKeyNode.left : parentKeyNode.right;
        BinaryTreeNode leftTargetNode = targetNode.left;
        BinaryTreeNode rightTargetNode = targetNode.right;
        BinaryTreeNode currentNode = leftTargetNode;
        while (currentNode != null && currentNode.right != null) {
            currentNode = currentNode.right;
        }
        currentNode.right = rightTargetNode;
        parentKeyNode.left = leftTargetNode;
        return root;
    }

    private static BinaryTreeNode getParentKeyNode(BinaryTreeNode root, int key) {
        BinaryTreeNode parentNode = null;
        while (root != null && root.data != -1) {
            if (key < root.data) {
                if (root.left != null && root.left.data == key) {
                    parentNode = root;
                    break;
                }
                root = root.left;
            } else if (key > root.data) {
                if (root.right != null && root.right.data == key) {
                    parentNode = root;
                    break;
                }
                root = root.right;
            }
        }
        return parentNode;
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

    static class BinaryTreeNode {
        int data;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode() {
            this.data = -1;
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
