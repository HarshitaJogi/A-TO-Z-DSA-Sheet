class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        ArrayList<Pair<Integer, Integer>> [] g = new ArrayList[n+1];

        for(int i=0; i<=n; i++){
            g[i] = new ArrayList<>();
        }

        for(int i=0; i<times.length; i++){
            int src_node = times[i][0];
            int target_node = times[i][1];
            int time = times[i][2];

            g[src_node].add(new Pair(target_node, time));
        }

        int INF = (int)1E9;
        int [] dist = new int [n+1];
        Arrays.fill(dist, INF);

        dijkstra(g, n, k, dist);

        for(int i=1; i<dist.length; i++){
           System.out.print(dist[i] + " ");
        }

        int ans = -1;
        for(int i=1; i<dist.length; i++){
            ans = Math.max(ans, dist[i]);
        }

        if(ans == INF) return -1;
        else return ans;

    }

    static void dijkstra (ArrayList<Pair<Integer, Integer>> [] g, int n, int k, int [] dist){

        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((x, y) -> x.getKey() - y.getKey());
        // pair has (dist, child node)
        pq.add(new Pair(0, k));
        dist[k] = 0;

        while(pq.size()>0){
            Pair<Integer, Integer> curr = pq.poll();
            int curr_dist = curr.getKey();
            int curr_node = curr.getValue();

            for(int i=0; i<g[curr_node].size(); i++){
                Pair<Integer, Integer> child = g[curr_node].get(i);
                int child_dist = child.getValue();
                int child_node = child.getKey();

                if(curr_dist + child_dist < dist[child_node]){
                    dist[child_node] = curr_dist + child_dist;
                    pq.add(new Pair(dist[child_node], child_node));
                }
            }
        }
        
    }
}
