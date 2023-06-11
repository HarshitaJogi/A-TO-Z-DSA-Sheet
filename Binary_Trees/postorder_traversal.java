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
    public List<Integer> postorderTraversal(TreeNode root) {
        
        List<Integer> traversal = new ArrayList<Integer>();
        postorder(root, traversal);
        return traversal;

    }
    static void postorder(TreeNode root, List<Integer> traversal){
        if(root == null) return;

        postorder(root.left, traversal);
        postorder(root.right, traversal);
        traversal.add(root.val);
    }
}