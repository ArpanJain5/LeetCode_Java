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
    StringBuilder result = new StringBuilder();
    public String tree2str(TreeNode root) {
        DFS(root);
        return result.toString();
    }
    public void DFS( TreeNode node){
        if (node == null)
            return ;
        result.append(node.val);
        if (node.right == null && node.left == null)
            return;
        result.append('(');
        DFS(node.left);
        result.append(')');
        if (node.right != null){
            result.append('(');
            DFS(node.right);
            result.append(')');
        }
    }
}