package binarytrees.easy;

/**
 * Leetcode:
 * 
 * Link: https://leetcode.com/problems/subtree-of-another-tree/
 * 
 * TC: O(2N) ~ O(N)
 * SC: O(1)
 * 
 */
public class P6_SubTree_Of_Another_Tree {
    public static void main(String[] args) {
        int[] nums1 = { 3, 4, 5, 1, 2 };
        TreeNode root = createTree(nums1, 0);

        int[] nums2 = { 4, 1, 2 };
        TreeNode subRoot = createTree(nums2, 0);

        boolean hasChild = isSubtree(root, subRoot);
        System.out.println("Root has a child subRoot : " + hasChild);
    }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) {
            return false;
        }
        String rootStr = getPreOrder(root);
        String subRootStr = getPreOrder(subRoot);
        return rootStr.contains(subRootStr);
    }

    /**
     * Using Pre-Order Traversal NLR
     * 
     * @param node
     * @param target
     * @return
     */
    private static String getPreOrder(TreeNode node) {
        if (node == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder("^");
        sb.append(node.val + "^");
        sb.append(getPreOrder(node.left) + "^");
        sb.append(getPreOrder(node.right) + "^");
        return sb.toString();
    }

    private static TreeNode createTree(int[] arr, int index) {
        TreeNode root = null;
        if (index < arr.length) {
            root = arr[index] != -1 ? new TreeNode(arr[index]) : null;
            if (root != null) {
                root.left = createTree(arr, 2 * index + 1);
                root.right = createTree(arr, 2 * index + 2);
            }
        }
        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int item) {
            val = item;
            left = right = null;
        }
    }
}
