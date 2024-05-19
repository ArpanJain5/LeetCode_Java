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
    private int moves;
    public int distributeCoins(TreeNode root) {
        moves = 0;
        postorderTraversal(root);
        return moves;
    }
    private int postorderTraversal(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftBalance = postorderTraversal(node.left);
        int rightBalance = postorderTraversal(node.right);
        int currentBalance = node.val + leftBalance + rightBalance - 1;
        moves += Math.abs(currentBalance);
        return currentBalance;
    }
}