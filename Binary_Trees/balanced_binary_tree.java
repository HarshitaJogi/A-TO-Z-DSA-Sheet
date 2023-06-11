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
    public boolean isBalanced(TreeNode root) {
        if(mxDepth(root) != -1) return true;
        return false;
    }

    static int mxDepth(TreeNode node){
        if(node == null) return 0;

        int leftht = mxDepth(node.left);
        if(leftht == -1) return -1;

        int rightht = mxDepth(node.right);
        if(rightht == -1) return -1;

        if(Math.abs(leftht - rightht)>1) return -1;
        return Math.max(leftht, rightht)+1;
    }
}