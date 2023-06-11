class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;

        int [][] dist = new int [m][n];
        boolean [][] vis = new boolean [m][n];

        ArrayList<Pair<Integer, Integer>> sources = new ArrayList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 0){
                    dist[i][j] = 0;
                    sources.add(new Pair(i, j));
                }
            }
        }

        bfs(mat, dist, sources, vis);

        return dist;

    }


    static void bfs(int [][] mat, int [][] dist, ArrayList<Pair<Integer, Integer>> sources, boolean [][] vis){

        int m = mat.length;
        int n = mat[0].length;

        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        for(int i=0; i<sources.size(); i++){
            Pair<Integer, Integer> source = sources.get(i);
            int row = source.getKey();
            int col = source.getValue();
            q.add(new Pair(row, col));
            vis[row][col] = true;
        }
      

        while(!q.isEmpty()){
            Pair<Integer, Integer> curr = q.poll();
            int curr_x = curr.getKey();
            int curr_y = curr.getValue();

            int [] x = {0, 0, 1, -1};
            int [] y = {1, -1, 0, 0};

            for(int i=0; i<4; i++){
                int child_x = curr_x + x[i];
                int child_y = curr_y + y[i];

                if(child_x>=m || child_x<0 || child_y>=n || child_y<0) continue;
                if(vis[child_x][child_y] == true) continue;
                if(mat[child_x][child_y] == 0) continue;

                dist[child_x][child_y] = dist[curr_x][curr_y] + 1;
                vis[child_x][child_y] = true;
                q.add(new Pair(child_x, child_y));
            }
        }
    }
}

