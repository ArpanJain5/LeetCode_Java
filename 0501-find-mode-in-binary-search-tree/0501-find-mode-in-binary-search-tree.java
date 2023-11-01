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
    public int[] findMode(TreeNode root) {
        ans=new ArrayList<>();
        max=new Pair(Integer.MIN_VALUE, 0);
        traverse(root, new HashSet<>());
        int ret[]=new int[ans.size()];
        int idx=0;
        for(int x: ans) {
            ret[idx++]=x;
        }
        return ret;
    }
    private List<Integer> ans;
    private Pair<Integer, Integer> max;
    private void traverse(TreeNode root, Set<Integer> done) {
        if(root==null) return;
        if(!done.contains(root.val)) {
            int freq=find(root, root.val);
            if(freq>max.getValue()) {
                max=new Pair(root.val, freq);
                ans.clear();
                ans.add(root.val);
            }else if(freq==max.getValue()){
                ans.add(root.val);
            }
            done.add(root.val);
        }
        traverse(root.left, done);
        traverse(root.right, done);
    }
    private int find(TreeNode root, int val) {
        if(root==null) return 0;
        int ret=0;
        if(root.val==val) {
            ret+=1+find(root.right, val)+find(root.left, val);
        }
        else if(root.val<val) {
            ret+=find(root.right, val);
        }else {
            ret+=find(root.left, val); 
        }
        return ret;
    }
}