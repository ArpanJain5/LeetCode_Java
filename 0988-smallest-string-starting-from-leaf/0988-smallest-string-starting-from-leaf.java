/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    String sb = "~";

    void helper(TreeNode root, StringBuilder holder) {
        if (root != null) {
            holder.append((char) ('a' + root.val));

            if (root.left == null && root.right == null) {
                holder.reverse();
                String str = holder.toString();
                holder.reverse();

                if (str.compareTo(sb) < 0) {
                    sb = str;
                }
            }
            helper(root.left, holder);
            helper(root.right, holder);
            holder.deleteCharAt(holder.length() - 1);
        }
    }

    public String smallestFromLeaf(TreeNode root) {
        helper(root, new StringBuilder());
        return sb;
    }
}