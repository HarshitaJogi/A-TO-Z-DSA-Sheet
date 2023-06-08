class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        // Same as topo sort, just reverse the arrow directions
        int V = graph.length;
        ArrayList<Integer> [] g = new ArrayList[V];
        for(int i=0; i<V; i++){
            g[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<V; i++){
            int x = i;
            for(int j=0; j<graph[i].length; j++){
                int y = graph[i][j];
                g[y].add(x);
            }
        }

        int [] indegree = new int [V];

        for(int i=0; i<g.length; i++){
            for(int child: g[i]){
                indegree[child] += 1;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<indegree.length; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        
        List<Integer> ans = new ArrayList<Integer>();

        while(!q.isEmpty()){
            int curr = q.poll();
            ans.add(curr);

            for(int child: g[curr]){
                indegree[child] -= 1;
                if(indegree[child]==0){
                    q.add(child);
                }
            }
        }

        Collections.sort(ans);

        return ans;
    }
}