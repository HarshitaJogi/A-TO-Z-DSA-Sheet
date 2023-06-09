class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        int INF = (int)1E9;
        
        // making the graph
        ArrayList<Pair<Integer, Integer>> [] g = new ArrayList[n];

        for(int i=0; i<n; i++){
            g[i] = new ArrayList<>();
        }

        for(int i=0; i<flights.length; i++){
            int source = flights[i][0];
            int destin = flights[i][1];
            int price = flights[i][2];

            g[source].add(new Pair(destin, price));
        }



        int [] dist = new int [n];
        Arrays.fill(dist, INF);

        dijkstra(n, g, src, k, dist);

        int ans = dist[dst];

        if(ans == INF) return -1;
        else return ans;
    }

    static void dijkstra (int n, ArrayList<Pair<Integer, Integer>> [] g, int src, int k, int [] dist){

        int INF = (int)1E9;

       Queue<Tuple> q = new LinkedList<>();

       // (no of stops, source, distance)
       q.add(new Tuple(0, src, 0));
       dist[src] = 0;

       while(!q.isEmpty()){
           Tuple curr = q.poll();
           int curr_stops = curr.first;
           int curr_src = curr.second;
           int curr_dist = curr.third;

           if(curr_stops > k) continue;

           for(int i=0; i<g[curr_src].size(); i++){
               Pair<Integer, Integer> child = g[curr_src].get(i);
               int child_node = child.getKey();
               int child_dist = child.getValue();

               if(curr_dist + child_dist < dist[child_node] && curr_stops <= k){
                   dist[child_node] = curr_dist + child_dist;
                                                            // bec now new dist will be the smaller updated value
                   q.add(new Tuple(curr_stops+1, child_node, curr_dist + child_dist));
               }
           }
       }

    }
}

class Tuple{
    int first, second, third;
    public Tuple(int first, int second, int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}