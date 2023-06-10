
//User function Template for Java
class Solution {

	public int[] shortestPath(int N,int M, int[][] edges) {
		
		// making graph
		ArrayList<pair> [] g = new ArrayList [N];
		for(int i=0; i<N; i++){
		    g[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++){
		    int src = edges[i][0];
		    int destin = edges[i][1];
		    int dist = edges[i][2];
		    
		    g[src].add(new pair(destin, dist));
		}
		
		int INF = (int)1E9;
		int [] dist = new int [N];
		Arrays.fill(dist, INF);
		
		dijkstra(g, dist);
		
		for(int i=0; i<dist.length; i++){
		    if(dist[i] == INF) dist[i] = -1;
		}
		
		return dist;
	}
	
	static void dijkstra(ArrayList<pair> [] g, int [] dist){
	    
	    PriorityQueue<pair> pq = new PriorityQueue<pair>((x, y) -> x.first - y.first);
	    // pair has (dist, node)
	    pq.add(new pair(0, 0));
	    dist[0] = 0;
	    
	    while(pq.size()>0){
	        pair curr = pq.poll();
	        int curr_node = curr.second;
	        int curr_dist = curr.first;
	        
	        for(int i=0; i<g[curr_node].size(); i++){
	            pair child = g[curr_node].get(i);
	            int child_node = child.first;
	            int child_dist = child.second;
	            
	            if(curr_dist + child_dist < dist[child_node]){
	                dist[child_node] = curr_dist + child_dist;
	                pq.add(new pair(dist[child_node], child_node));
	            }
	        }
	    }
	}
}

class pair{
    int first, second;
    public pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}