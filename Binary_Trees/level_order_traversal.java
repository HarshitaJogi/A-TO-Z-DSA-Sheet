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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        ans = func(root);
        return ans;
    }

    static List<List<Integer>> func(TreeNode node){

        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if(node == null) return ans;

        q.add(node);

        while(!q.isEmpty()){

            int noOfNodesInLevel = q.size();
            List<Integer> level = new ArrayList<Integer>();

            // since we want all nodes on a level to be in one list, insead of taking a node and popping its children
            // we take all nodes in current value and pop them out of list

            for(int i=0; i<noOfNodesInLevel; i++){
                TreeNode curr = q.poll();

                level.add(curr.val);

                if(curr.left != null){
                    q.add(curr.left);
                }

                if(curr.right != null){
                    q.add(curr.right);
                }
            }

            ans.add(level);
        }

        return ans;
    }
}