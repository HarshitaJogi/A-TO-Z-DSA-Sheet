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
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> ans = new ArrayList<>();
        levelOrder(root, ans);
        return ans;
    }

    static void levelOrder(TreeNode root, List<Integer> ans){
        if(root == null) return;
        Queue<Pair<Integer, TreeNode>> q = new LinkedList<>();
        TreeMap<Integer, TreeNode> m = new TreeMap<>();

        q.add(new Pair(0, root));

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0; i<size; i++){
                Pair<Integer, TreeNode> curr = q.poll();
                int curr_level = curr.getKey();
                TreeNode curr_node = curr.getValue();

                // we want last node of every horizontal level
                m.put(curr_level, curr_node);

                //left
                if(curr_node.left != null){
                    int child_level = curr_level + 1;
                    TreeNode child_node = curr_node.left;
                    q.add(new Pair(child_level, child_node));
                }

                //right
                if(curr_node.right != null){
                    int child_level = curr_level + 1;
                    TreeNode child_node = curr_node.right;
                    q.add(new Pair(child_level, child_node));
                }
            }
        }

        // adding all values in ans
        for(Map.Entry<Integer, TreeNode> entry: m.entrySet()){
            TreeNode node = entry.getValue();
            ans.add(node.val);
        }
    }
}