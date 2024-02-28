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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            ArrayList<Integer> ll = new ArrayList<>();
            while(n>0){
                TreeNode x = q.poll();
                if(x.left != null)
                    q.add(x.left);
                if(x.right != null)    
                    q.add(x.right);
                ll.add(x.val);
                n--;
            }
            ans.add(ll);
        }
        return ans.get(ans.size()-1).get(0);
    }
}