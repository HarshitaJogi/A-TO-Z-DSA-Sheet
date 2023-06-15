//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

class Solution
{
	ArrayList <Integer> boundary(Node node)
	{
	    ArrayList <Integer> traversal = new ArrayList<>();
	    if(node.left != null || node.right != null){
	         traversal.add(node.data);
	    }
	   
	   leftboundary(node, traversal);
	    leafnodes(node, traversal);
	    
	    ArrayList <Integer> rightnodes = new ArrayList<>();
	    // node.right bec we dont want root node to repeat
	   rightboundary(node, rightnodes);
	    
	    // bec we want right nodes in reverse order
	    int r_size = rightnodes.size();
	    for(int i=r_size-1; i>=0; i--){
	        traversal.add(rightnodes.get(i));
	    }
	    
	    return traversal;
	}
	
	static void leftboundary (Node node, ArrayList<Integer> traversal){
	        Node curr = node.left;
	    while(curr != null){
	        // only add in traversal if it is not a leaf node
	        if(curr.left != null || curr.right != null) traversal.add(curr.data);
	        
	        if(curr.left != null) curr=curr.left;
	        else curr = curr.right;
	       
	    }
	   
	}
	
	static void leafnodes (Node node, ArrayList<Integer> traversal){
	    if(node == null) return;
	    
	    if(node.left == null && node.right == null) traversal.add(node.data);
	    
	    if(node.left != null){
	        leafnodes(node.left, traversal);
	    }
	    
	    if(node.right != null){
	        leafnodes(node.right, traversal);
	    }
	    
	}
	
	static void rightboundary(Node node, ArrayList<Integer> rightnodes){
	    Node curr = node.right;
	    while(curr != null){
	        // only add in traversal if it is not a leaf node
	        if(curr.left != null || curr.right != null) rightnodes.add(curr.data);
	        
	        if(curr.right != null) curr=curr.right;
	        else curr = curr.left;
	    }
	}
}
