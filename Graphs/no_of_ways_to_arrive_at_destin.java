
class Solution {
    public int countPaths(int n, int[][] roads) {
        ArrayList<Pair<Integer, Integer>>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }

        for (int i = 0; i < roads.length; i++) {
            int x = roads[i][0];
            int y = roads[i][1];
            int time = roads[i][2];

            // bec undirected
            g[x].add(new Pair(y, time));
            g[y].add(new Pair(x, time));
        }

        long INF = (long) 1e18;
        long[] time = new long[n];
        Arrays.fill(time, INF);

        long[] ways = new long[n];
        Arrays.fill(ways, 0);

        dijkstra(g, time, ways);

        int M = (int) (1e9 + 7);
        int ans = (int) (ways[n - 1] % M);

        return ans;
    }

    static void dijkstra(ArrayList<Pair<Integer, Integer>>[] g, long[] time, long[] ways) {
        int M = (int) (1e9 + 7);
        PriorityQueue<Pair<Long, Integer>> pq = new PriorityQueue<>((x, y) -> x.getKey().compareTo(y.getKey()));
        // pair has (time, node)
        pq.add(new Pair(0L, 0));
        time[0] = 0;
        ways[0] = 1;

        while (!pq.isEmpty()) {
            Pair<Long, Integer> curr = pq.poll();
            long curr_time = curr.getKey();
            int curr_node = curr.getValue();

            for (int i = 0; i < g[curr_node].size(); i++) {
                Pair<Integer, Integer> child = g[curr_node].get(i);
                int child_time = child.getValue();
                int child_node = child.getKey();

                // this is the first time I am coming with this short distance
                if (curr_time + child_time < time[child_node]) {
                    time[child_node] = curr_time + child_time;
                    pq.add(new Pair(time[child_node], child_node));
                    ways[child_node] = ways[curr_node];
                }
                // this is more than one time I am arriving with this shortest distance
                else if (curr_time + child_time == time[child_node]) {
                    ways[child_node] = (ways[child_node] + ways[curr_node]) % M;
                }
            }
        }
    }
}
