/*
*   edges: vector of vectors which represents the graph
*   S: source vertex to start traversing graph with
*   V: number of vertices
*/
class Solution {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        
        int INF = (int)1E8;
        int [] dist = new int [V];
        Arrays.fill(dist, INF);
        dist[S] = 0;
        
        for(int i=0; i<=(V-1); i++){
            
            for(int j=0; j<edges.size(); j++){
                int u = edges.get(j).get(0); // source
                int v = edges.get(j).get(1); // destin
                int wt = edges.get(j).get(2); // wt
                
                if(dist[u] + wt < dist[v]){
                    dist[v] = dist[u] + wt;
                }
            }
        }
        
        // to check if there is a negative cycle, we perform it once more
        for(int j=0; j<edges.size(); j++){
            int u = edges.get(j).get(0); // source
            int v = edges.get(j).get(1); // destin
            int wt = edges.get(j).get(2); // wt
            
            if(dist[u] + wt < dist[v]){
                int [] arr = {-1};
                return arr;
            }
        }
        
        return dist;
       
    }
}
