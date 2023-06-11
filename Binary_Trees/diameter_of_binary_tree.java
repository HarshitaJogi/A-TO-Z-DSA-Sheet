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
    public int diameterOfBinaryTree(TreeNode root) {
        
        int [] diameter = new int [1];
        int depth = mxDepth(root, diameter);
        return diameter[0];
    }
    
    static int mxDepth(TreeNode node, int [] diameter){
        if(node == null) return 0;

        int leftht = mxDepth(node.left, diameter);
        int rightht = mxDepth(node.right, diameter);

        diameter[0] = Math.max(diameter[0], (leftht + rightht));

        return Math.max(leftht, rightht)+1;
    }
}