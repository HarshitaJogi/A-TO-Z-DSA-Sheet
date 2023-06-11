class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        
        boolean [] vis = new boolean [V];
        
        boolean ans = false;
        for(int i=0; i<V; i++){
            if(vis[i] == true) continue;
            
            if(dfs(adj, vis, i, -1) == true){
                ans = true;
                break;
            }
        }
        return ans;
    }
    
    static boolean dfs(ArrayList<ArrayList<Integer>> adj, boolean [] vis, int vertex, int par){
        
        vis[vertex] = true;
        boolean loopExists = false;
        
        for(int child: adj.get(vertex)){
            if(vis[child] == true && child == par) continue;
            if(vis[child] == true) return true;
            
            loopExists |= dfs(adj, vis, child, vertex);
        }
        
        
        return loopExists;
    }
}