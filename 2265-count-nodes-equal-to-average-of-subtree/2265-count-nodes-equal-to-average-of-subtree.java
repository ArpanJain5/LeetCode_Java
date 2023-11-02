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
    public int averageOfSubtree(TreeNode root) {
      average ans = helper(root);
      return  ans.val; 
    }
    public average helper(TreeNode root){
        if(root==null){
            average ans = new average(0,0,0);
            return ans;
        }
        average ans1 = helper(root.left);
        average ans2 = helper(root.right);
        average ans = new average(ans1.count+ans2.count+1,ans1.sum+ans2.sum+root.val,ans1.val+ans2.val);
        if(ans.sum/ans.count == root.val){
            ans.val = ans.val+1;
        }
        return ans;
    }
}
class average{
    int count;
    int sum;
    int val;
    public average(int count,int sum,int val){
        this.count = count;
        this.sum = sum;
        this.val = val;
    }
}