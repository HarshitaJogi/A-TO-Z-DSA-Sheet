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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> pretraversal = new ArrayList<Integer>();
        preorder(root, pretraversal);
        return pretraversal;
    }

    static void preorder(TreeNode root, List<Integer> pretraversal){
        if(root == null) return;

        pretraversal.add(root.val);
        preorder(root.left, pretraversal);
        preorder(root.right, pretraversal);
    }
}
