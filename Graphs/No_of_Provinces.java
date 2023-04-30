class Solution {
    
    static boolean [] vis = new boolean [505];
    static ArrayList<Integer> [] g = new ArrayList[505];
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        
        Arrays.fill(vis, false);
        for(int i=0; i<g.length; i++){
            g[i] = new ArrayList<Integer>();
        }
        
        // converting matrix to list
        
        for(int i=0; i<adj.size(); i++){
            for(int j=0; j<adj.get(i).size(); j++){
                int x = adj.get(i).get(j);
                if(x == 1){
                    g[i+1].add(j+1);
                    // g[j+1].add(i);
                }
            }
        }
        
        int ans = 0;
        for(int i=1; i<=V; i++){
            if(vis[i] == true) continue;
            dfs(i);
            ans++;
        }
        
        return ans;
    }
    
    static void dfs(int vertex){
        vis[vertex] = true;
        
        for(int child: g[vertex]){
            if(vis[child] == true) continue;
            dfs(child);
        }
    }
};
