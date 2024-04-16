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
    int depth;
    public void traverse(TreeNode current, int count, int val)
    {
        if(count == depth-1)
        {
            current.left=new TreeNode(val,current.left,null);
            current.right =new TreeNode(val,null,current.right);
            return;
        }
        if(current.left!=null)
        traverse(current.left,count+1,val);
        if(current.right!=null)
        traverse(current.right,count+1,val);
        return;
    }
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        this.depth=depth;
        if(depth ==1)
        {
            return new TreeNode(val,root,null);
        }
        traverse(root,1,val);
        return root;
    }
}