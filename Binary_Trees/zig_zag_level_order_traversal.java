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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> ans = new ArrayList<>();
        ans = zigzag(root);
        return ans;

    }

    static List<List<Integer>> zigzag(TreeNode node){
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if(node == null) return ans;
        q.add(node);

        boolean leftToRight = true;

        while(!q.isEmpty()){
            int noOfNodesInaLevel = q.size();

            List<Integer> level = new ArrayList<Integer>();
            for(int i=0; i<noOfNodesInaLevel; i++){
                TreeNode curr = q.poll();
                 
                level.add(curr.val);

                if(curr.left != null){
                    q.add(curr.left);
                }

                if(curr.right != null){
                    q.add(curr.right);
                }
            }

            if(leftToRight != true) Collections.reverse(level);
            ans.add(level);
            leftToRight = !leftToRight;
        }

        return ans;
    }
}