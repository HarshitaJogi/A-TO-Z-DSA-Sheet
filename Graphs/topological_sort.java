class Solution
{
    static boolean [] vis = new boolean [10005];
    static ArrayList<Integer> list = new ArrayList<Integer>();
    static Stack<Integer> st = new Stack<Integer>();
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        
        // TOPO SORT BY DFS
        
        // Arrays.fill(vis, false);
        // list.clear();
        // st.clear();
        // // add your code here
        // for(int i=0; i<V; i++){
        //     if(vis[i] == true) continue;
        //     dfs(i, adj);
        // }
        
        // int [] ans = new int [V];
        
        
        // int i=0;
        // while(!st.isEmpty()){
        //     int x = st.peek();
        //     ans[i] = x;
        //     // System.out.print(x + " ");
        //     st.pop();
        //     i++;
        // }
        
        
        
        
        // KHANS ALGORITHM : BFS BY TOPOLOGICAL SORT
        // indegree shows the number of arrows comming in the node for that particular node
        int [] indegree = new int [V];
        for(int i=0; i<V; i++){
            for(int child: adj.get(i)){
                indegree[child] += 1;
            }
        }
        
        int [] ans = new int [V];
        Queue <Integer> q = new LinkedList<>();
        
        for(int i=0; i<V; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        
        int i=0;
        while(!q.isEmpty()){
            int curr = q.poll();
            ans[i] = curr;
            i++;
            for(int child: adj.get(curr)){
                indegree[child] -= 1;
                if(indegree[child]==0){
                    q.add(child);
                }
            }
        }
        
        // for(int j=0; j<ans.length; j++){
        //     System.out.print(ans[j] + " ");
        // }
        // System.out.println();
        
        
        return ans;
        
        
    }
    
    
    // static void dfs(int node, ArrayList<ArrayList<Integer>> adj){
    //     vis[node] = true;
    //     // System.out.print(node + " ");
        
    //     for(int child: adj.get(node)){
    //         if(vis[child] == true) continue;
    //         dfs(child, adj);
    //     }
    //     // list.add(node);
    //     st.add(node);
    // }
    
}
