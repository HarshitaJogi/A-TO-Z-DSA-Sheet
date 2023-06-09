class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {

        int [] dist = new int [100010];
        int INF = (int)(1E9);
        Arrays.fill(dist, INF);
        
        int ans = dijkstra(arr, start, end, dist);
        
        return ans;
    }
    
    static int dijkstra(int [] arr, int start, int end, int [] dist){
        
        int M = (int)1E5;
        
        Queue<Pair> q = new LinkedList<>();
        // pair has (level, node)
        q.add(new Pair(0, start));
        dist[start] = 0;
        
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int curr_level = curr.x;
            int curr_node = curr.y;
            
            // children of current are the number we get after multiplying current node with
            // numbers in given array
            for(int i=0; i<arr.length; i++){
                int child_node = (curr_node * arr[i])%M;
                // int child_level = curr_level + 1;
                
                if(curr_level + 1 < dist[child_node]){
                    dist[child_node] = curr_level + 1;
                    if(child_node == end) return dist[child_node];
                    q.add(new Pair(dist[child_node], child_node));
                }
            }
        }
        return -1;
    }
}

class Pair{
    int x, y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
