class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        
        // FLOYD WARSHAL (all point shortest distance)
        
        int [][] dist = new int [n][n];

        int INF = (int)1E9;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==j) dist[i][j] = 0;
                else dist[i][j] = INF;
            }
        }

        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];

            dist[u][v] = wt;
            dist[v][u] = wt;
        }

        // for(int i=0; i<n; i++){
        //     for(int j=0; j<n; j++){
        //         System.out.print(dist[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        for(int via=0; via<n; via++){

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    dist[i][j] = Math.min(dist[i][j], (dist[i][via] + dist[via][j]));
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }

        // for each node, to find the number of nodes with distance <= threshold
        int [] nodes = new int [n];
            System.out.println("Nodes array: ");
        for(int i=0; i<n; i++){
            int no_of_nodes = 0;
            for(int j=0; j<n; j++){
                if(dist[i][j] == 0) continue;
                if(dist[i][j] <= distanceThreshold) no_of_nodes += 1;
            }
            nodes[i] = no_of_nodes;
            System.out.print(nodes[i] + " ");
        }
        System.out.println();

        int node_with_min_cities = INF;
        int ans = -1;
         
        for(int i=0; i<nodes.length; i++){
            if(nodes[i] <= node_with_min_cities){
                node_with_min_cities = nodes[i];
                ans = Math.max(ans, i);
            }
        }
        

        return ans;
    }
}