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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = getLeaves(root1);
        List<Integer> l2 = getLeaves(root2);
        return l1.equals(l2);
    }

    public List<Integer> getLeaves(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode curr = root;

        while (curr != null || s.size() > 0){ 
            while (curr !=  null){ 
                s.push(curr);
                curr = curr.left;
            } 
            curr = s.pop();
            if(curr.left == null && curr.right == null) ans.add(curr.val);
            curr = curr.right;
        }
        return ans;
    }
}