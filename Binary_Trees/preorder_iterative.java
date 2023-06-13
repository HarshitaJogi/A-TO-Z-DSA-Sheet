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


    // ITERATIVE
    static void preorder(TreeNode root, List<Integer> traversal){
        if(root == null) return;
        Stack<TreeNode> st = new Stack<TreeNode>();
        st.add(root);
        

        while(!st.isEmpty()){
            TreeNode curr = st.peek();
            traversal.add(curr.val);
            st.pop();

            // we add right first bec stack is last in first out, so we want left to come out first
            if(curr.right != null){
                st.add(curr.right);
            }

            if(curr.left != null){
                st.add(curr.left);
            }
            
        }
    }
}