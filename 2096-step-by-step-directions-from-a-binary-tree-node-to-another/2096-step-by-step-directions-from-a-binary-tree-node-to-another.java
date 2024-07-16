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
    String a = "";
    String b = "";
    private void buildPath(TreeNode root, int start, int end, StringBuilder sb) {
        if(root == null)
            return;
        if(root.val == start) {
            a = sb.toString();
        }
        if(root.val == end) {
            b = sb.toString();
        }
        if(root.left != null) {
            sb.append("L");
            buildPath(root.left, start, end, sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if(root.right != null) {
            sb.append("R");
            buildPath(root.right, start, end, sb);
            sb.deleteCharAt(sb.length()-1);
        }
        return;  
    }
    public String getDirections(TreeNode root, int startValue, int destValue) {
        buildPath(root, startValue, destValue, new StringBuilder());
        if(a == "")
            return b;
        if(b == "")
            return "U".repeat(a.length());
        int i=0;
        while(i<a.length() && i<b.length() && a.charAt(i) == b.charAt(i))
            i++;
        return "U".repeat(a.length()-i) + b.substring(i, b.length());
    }
}