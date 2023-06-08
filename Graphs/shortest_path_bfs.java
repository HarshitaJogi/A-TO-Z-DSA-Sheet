class Solution {
    
    static boolean [] vis = new boolean [1000];
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        
        Arrays.fill(vis, false);
        ArrayList<Integer> [] g = new ArrayList[n];
        for(int i=0; i<g.length; i++){
            g[i] = new ArrayList<Integer>();
        }
        
        for(int i=0; i<edges.length; i++){
            int x = edges[i][0];
            int y = edges[i][1];
            
            g[x].add(y);
            g[y].add(x);
        }
        
        int [] level = new int [n];
        Arrays.fill(level, -1);
        
        bfs(src, g, level);
        
        
        return level;
        
    }
    
    static void bfs(int node, ArrayList<Integer> [] g, int [] level){
        vis[node] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        level[node] = 0;
        
        while(!q.isEmpty()){
            int curr = q.poll();
            
            for(int child: g[curr]){
                if(vis[child] == true) continue;
                q.add(child);
                vis[child] = true;
                level[child] = level[curr] + 1;
            }
        }
    }
}