// User function Template for Java

class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    
	    // convert to graph
	   ArrayList<pair> [] g = new ArrayList[V];

        for(int i=0; i<V; i++){
            g[i] = new ArrayList<>();
        }

        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];

            g[u].add(new pair(v, wt));
            g[v].add(new pair(u, wt));
        }
	    
	    boolean [] vis = new boolean [V];
	    Arrays.fill(vis, false);
	    
	    ArrayList<pair> mst = new ArrayList<>();
	    
	    int ans = prims(g, vis, mst);
	    
	   // for(int i=0; i<mst.size(); i++){
	   //     System.out.println(mst.get(i).first + " - " + mst.get(i).second);
	   // }
	    
	    return ans;
	    
	}
	
	static int prims(ArrayList<pair> [] g, boolean [] vis, ArrayList<pair> mst){
	    
	    int sum = 0;
	    PriorityQueue<tuple> pq = new PriorityQueue<>((x, y) -> x.first - y.first);
	    // tuple has wt, node, parent
	    pq.add(new tuple(0, 0, -1));
	    
	    while(pq.size()>0){
	        tuple curr = pq.poll();
	        int curr_wt = curr.first;
	        int curr_node = curr.second;
	        int curr_parent = curr.third;
	        
	        if(vis[curr_node] == true) continue;
	        
	        vis[curr_node] = true;
	        sum += curr_wt;
	        mst.add(new pair(curr_node, curr_parent));
	        
	        for(int i=0; i<g[curr_node].size(); i++){
	            pair child = g[curr_node].get(i);
	            int child_wt = child.second;
	            int child_node = child.first;
	            
	            if(vis[child_node] != true){
	                pq.add(new tuple(child_wt, child_node, curr_node));
	            }
	   
	        }
	    }
	    
	    return sum;
	}
}

class pair{
    int first, second;
    public pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class tuple{
    int first, second, third;
    public tuple(int first, int second,int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}