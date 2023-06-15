//User function Template for Java

/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        levelOrder(root, ans);
        
        return ans;
        
    }
    
    
    static void levelOrder(Node root, ArrayList<Integer> ans){
        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer, Node> m = new TreeMap<>();
        
        q.add(new Pair(0, root));
        
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i=0; i<size; i++){
                Pair curr = q.poll();
                int curr_line = curr.x;
                Node curr_node = curr.y;
                
                // only add the first occurance of line number's node in map
                if(!m.containsKey(curr_line)){
                    m.put(curr_line, curr_node);
                }
                
                // left
                if(curr_node.left != null){
                    int child_line = curr_line-1;
                    Node child_node = curr_node.left;
                    q.add(new Pair(child_line, child_node));
                }
                
                // right
                if(curr_node.right != null){
                    int child_line = curr_line+1;
                    Node child_node = curr_node.right;
                    q.add(new Pair(child_line, child_node));
                }
            
            }
            
        }
        
        // add all nodes in arraylist ans
        int n = m.size();
        for(Map.Entry<Integer, Node> entry: m.entrySet()){
            Node node = entry.getValue();
            ans.add(node.data);
        }
    }
    
}

class Pair{
    int x; 
    Node y;
    Pair(int x, Node y){
        this.x = x;
        this.y = y;
    }
}