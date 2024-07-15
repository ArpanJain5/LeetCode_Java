/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodes = new HashMap<>();
        Set<Integer> children = new HashSet<>();
        for (int[] d : descriptions) {
            int parentVal = d[0];
            int childVal = d[1];
            boolean isLeft = d[2] == 1;
            TreeNode parent = nodes.getOrDefault(parentVal, new TreeNode(parentVal));
            TreeNode child = nodes.getOrDefault(childVal, new TreeNode(childVal));
            if (isLeft) {
                parent.left = child;
            }
            else {
                parent.right = child;
            }
            nodes.put(parentVal, parent);
            nodes.put(childVal, child);
            children.add(childVal);
        }
        TreeNode root = null;
        for (int[] d : descriptions) {
            if (!children.contains(d[0])) {
                root = nodes.get(d[0]);
                break;
            }
        }
        return root;
    }
}