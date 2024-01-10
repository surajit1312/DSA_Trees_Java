package binarytrees.easy;

/**
 * 
 * GeeksForGeeks: Invert Binary Tree
 * 
 * Link: https://www.geeksforgeeks.org/problems/mirror-tree/1
 * 
 * TC: O(N), where N is number of nodes
 * SC: O(H) ~ O(N), where H is height of Binary Tree and in case of skewed Tree,
 * H = N so, Auxiliary Recursive Stack Space SC = O(N)
 * 
 */
public class P5_Invert_Binary_Tree {
    public static void main(String[] args) {
        int[] nums = { 4, 2, 7, 1, 3, 6, 9 };
        Node root = createTree(nums, 0);
        Node mirroredRoor = mirror(root);
        System.out.println("Inverted Binary Tree : " + mirroredRoor);
    }

    private static Node mirror(Node node) {
        mirroredTree(node);
        return node;
    }

    private static void mirroredTree(Node root) {
        if (root == null) {
            return;
        }
        mirroredTree(root.left);
        mirroredTree(root.right);
        Node temp = root.right;
        root.right = root.left;
        root.left = temp;
    }

    private static Node createTree(int[] arr, int index) {
        Node root = null;
        if (index < arr.length) {
            root = arr[index] != -1 ? new Node(arr[index]) : null;
            if (root != null) {
                root.left = createTree(arr, 2 * index + 1);
                root.right = createTree(arr, 2 * index + 2);
            }
        }
        return root;
    }

    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }
}
