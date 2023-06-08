class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        
        int [] indegree = new int [V];
        for(int i=0; i<indegree.length; i++){
            for(int child: adj.get(i)){
                indegree[child] += 1;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> topo = new ArrayList<Integer>();
        
        for(int i=0; i<V; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        
        while(!q.isEmpty()){
            int curr = q.poll();
            topo.add(curr);
            
            for(int child: adj.get(curr)){
                indegree[child] -= 1;
                if(indegree[child] == 0){
                    q.add(child);
                }
            }
        }
        
        if(topo.size() == V) return false; // no cycle
        else return true;
    }
}