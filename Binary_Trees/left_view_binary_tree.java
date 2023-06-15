/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/
class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        levelOrder(root, ans);
        
        return ans;
    }
    
    static void levelOrder(Node root, ArrayList<Integer> ans){
        if(root == null) return;
        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer, Node> m = new TreeMap<>();
        
        q.add(new Pair(0, root));
        
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i=0; i<size; i++){
                Pair curr = q.poll();
                int curr_line = curr.x;
                Node curr_node = curr.y;
                
                // here we want first node of every horizontal level
                if(!m.containsKey(curr_line)){
                    m.put(curr_line, curr_node);
                }
                 
                
                // left
                if(curr_node.left != null){
                    int child_line = curr_line+1;
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