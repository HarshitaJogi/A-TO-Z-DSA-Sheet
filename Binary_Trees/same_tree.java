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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        ArrayList<Integer> p_path = new ArrayList<Integer>();
        ArrayList<Integer> q_path = new ArrayList<Integer>();

        preorder(p, p_path);
        preorder(q, q_path);

        return p_path.equals(q_path);
    }

    static void preorder(TreeNode node, ArrayList<Integer> path){
        if(node == null){
            path.add(0);
            return;
        }

        path.add(node.val);
        preorder(node.left, path);
        preorder(node.right, path);
    }
}