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
    public int maxPathSum(TreeNode root) {
        int [] maxSum = {-1500};
        int depth = mxDepth(root, maxSum);
        return maxSum[0];
    }

    static int mxDepth(TreeNode node, int [] maxSum){
        if(node == null) return 0;

        int leftmx = Math.max(0, mxDepth(node.left, maxSum));
        int rightmx = Math.max(0, mxDepth(node.right, maxSum));
        int val = node.val;

        maxSum[0] = Math.max(maxSum[0], leftmx+rightmx+node.val);

        return Math.max(leftmx, rightmx)+val;
    }
}