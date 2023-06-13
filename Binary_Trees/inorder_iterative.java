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
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> traversal = new ArrayList<Integer>();
        inorder(root, traversal);
        return traversal;
    }

    // ITERATIVE
    static void inorder(TreeNode node, List<Integer> traversal){
        Stack<TreeNode> st = new Stack<TreeNode>();
        
        while(true){
            if(node != null){
                st.add(node);
                node = node.left;
            }
            else{
                if(st.isEmpty() == true) break;

                node = st.pop();
                traversal.add(node.val);
                node = node.right;
            }
        }

    }

}