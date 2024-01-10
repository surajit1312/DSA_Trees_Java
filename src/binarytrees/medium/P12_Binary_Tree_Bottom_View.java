package binarytrees.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * 
 * GeeksForGeeks: Bottom View of Binary Tree
 * 
 * Link: https://www.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
 * 
 * TC: O(N) where N is the number of nodes in the Tree
 * SC: O(N)
 */
public class P12_Binary_Tree_Bottom_View {
    public static void main(String[] args) {
        int[] nums = { 20, 8, 22, 5, 3, -1, 25, -1, -1, 10, 14, -1, -1, -1, -1 };
        Node root = createTree(nums, 0);
        ArrayList<Integer> view = bottomView(root);
        System.out.println("Bottom view of Binary Tree is : " + view);
    }

    private static ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> view = new ArrayList<Integer>();
        if (root == null) {
            return view;
        }
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.offer(new Pair(0, root));
        while (!queue.isEmpty()) {
            Pair currentPair = queue.poll();
            map.put(currentPair.offset, currentPair.node.data);
            if (currentPair.node.left != null) {
                queue.offer(new Pair(currentPair.offset - 1, currentPair.node.left));
            }
            if (currentPair.node.right != null) {
                queue.offer(new Pair(currentPair.offset + 1, currentPair.node.right));
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            view.add(entry.getValue());
        }
        return view;
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

    static class Pair {
        int offset;
        Node node;

        public Pair(int offset, Node node) {
            this.offset = offset;
            this.node = node;
        }
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
}
