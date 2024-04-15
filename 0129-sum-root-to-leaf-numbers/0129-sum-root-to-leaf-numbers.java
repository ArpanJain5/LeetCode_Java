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
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        return calculate(root,0);
    }
    public int calculate(TreeNode node,int sum){
        sum=sum*10+node.val;
        int ls=0,rs=0;
        if(node.left==null && node.right==null){
            return sum;
        }
        if(node.left!=null){
            ls=calculate(node.left,sum);
        }
        if(node.right!=null){
            rs=calculate(node.right,sum);
        }
        return ls+rs;
    }
}