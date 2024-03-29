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

    // ITERATIVE USING 2 STACKS
    static void postorder(TreeNode root, List<Integer> traversal){
        Stack<TreeNode> st1 = new Stack<TreeNode>();
        Stack<TreeNode> st2 = new Stack<TreeNode>();

        if(root == null) return;

        st1.add(root);
        while(!st1.isEmpty()){
            TreeNode node = st1.peek();
            st2.add(node);
            st1.pop();

            if(node.left != null) st1.add(node.left);
            if(node.right != null) st1.add(node.right);
        }

        while(!st2.isEmpty()){
            TreeNode node = st2.peek();
            traversal.add(node.val);
            st2.pop();
        }

    }

}