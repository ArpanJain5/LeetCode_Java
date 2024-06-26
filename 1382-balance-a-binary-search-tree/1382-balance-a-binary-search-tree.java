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
    public TreeNode balanceBST(TreeNode root) {
        var arr = new ArrayList<Integer>();
        makeSortedArray(root, arr);
        var balancedRoot = makeBalanced(arr, 0, arr.size() - 1);
        return balancedRoot;
    }
    public TreeNode makeBalanced(List<Integer> arr, int left, int right) {
        if(right < left) {
            return null;
        }
        var middle = left + (right - left) / 2;
        var balancedRoot = new TreeNode(arr.get(middle));
        balancedRoot.left = makeBalanced(arr, left, middle-1);
        balancedRoot.right = makeBalanced(arr, middle+1, right);
        return balancedRoot;
    }
    public void makeSortedArray(TreeNode root, List<Integer> arr) {
        if(root == null) {
            return;
        }
        makeSortedArray(root.left, arr);
        arr.add(root.val);
        makeSortedArray(root.right, arr);
    }
}