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
    List<TreeNode> ans;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        ArrayList<Integer> l = new ArrayList<>();
        ans=new ArrayList<>();
        for(int i:to_delete){
            l.add(i);
        }
        solve(root,l);
        
        if(!l.contains(root.val)){
            ans.add(root);
        }
        return ans;
    }
    public TreeNode solve(TreeNode root,ArrayList<Integer> delete){
        if(root == null) return null;

        root.left = solve(root.left,delete);
        root.right = solve(root.right,delete);

        if(delete.contains(root.val)){
            if(root.left!=null){
                ans.add(root.left);
            }
            if(root.right!=null){
                ans.add(root.right);
            }
            return null;
        }
        return root;
    }
}