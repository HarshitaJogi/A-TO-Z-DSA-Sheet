class Solution {
    public boolean isBipartite(int[][] graph) {
        // graph is already given in g form
        // graph is bipartite if it has even length cycle

        int n = graph.length;

        int [] colour = new int [n+5];
        Arrays.fill(colour, -1);

        boolean [] vis = new boolean [n+5];

        boolean ans = true;
        for(int i=0; i<n; i++){
            if(vis[i] == true) continue;
            if(colour[i] == -1){
                ans = bfs(i, graph, vis, colour);
                if(ans == false) return false;
            }  
        }

        return ans;
        
    }

    static boolean bfs(int vertex, int [][] g, boolean [] vis, int [] colour){
        Queue<Integer> q = new LinkedList<>();
        q.add(vertex);
        colour[vertex] = 0;

        while(!q.isEmpty()){
            int curr_node = q.poll();
            int curr_colour = colour[curr_node];

            for(int child: g[curr_node]){
                // means parent & child hv same colour, so not bipartite
                if(vis[child] == true && colour[child] == curr_colour) return false; 
                if(vis[child] == true) continue; 

                // store opposite colour of parent, i.e. current node
                if(curr_colour == 1) colour[child] = 0;
                else colour[child] = 1;

                vis[child] = true;
                q.add(child);
            }
        }

        return true;
    }
}