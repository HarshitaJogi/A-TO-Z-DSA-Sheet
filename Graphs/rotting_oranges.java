class Solution {
    static int m, n;

    public int orangesRotting(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        boolean [][] vis = new boolean [m][n];
        int [][] level = new int [m][n];

        for(int i=0; i<vis.length; i++){
            for(int j=0; j<vis[0].length; j++){
                vis[i][j] = false;
            }
        }

        for(int i=0; i<level.length; i++){
            for(int j=0; j<level[0].length; j++){
                level[i][j] = 0;
            }
        }

        ArrayList<Pair<Integer, Integer>> sources = new ArrayList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 2){
                      sources.add(new Pair(i, j));
                }
            }
        }

        bfs(grid, sources, vis, level);
      

        for(int i=0; i<level.length; i++){
            for(int j=0; j<level[0].length; j++){
                System.out.print(level[i][j] + " ");
            }
            System.out.println();
        }

        int ans = -1;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1) return -1;
                ans = Math.max(ans, level[i][j]);
            }
        }

        return ans;

    }

    static void bfs(int [][] grid, ArrayList<Pair<Integer, Integer>> sources, boolean [][] vis, int [][] level){
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

            int [] x_coord = {0, 0, 1, -1};
            int [] y_coord = {1, -1, 0, 0};

            for(int i=0; i<4; i++){
                int child_x = curr_x + x_coord[i];
                int child_y = curr_y + y_coord[i];

                if(child_x >= m || child_x < 0 || child_y >= n || child_y < 0) continue;

                if(vis[child_x][child_y] == true) continue;

                if(grid[child_x][child_y] != 1) continue;

                vis[child_x][child_y] = true;
                level[child_x][child_y] = level[curr_x][curr_y] + 1;
                // make the orange rotten
                grid[child_x][child_y] = 2;
                q.add(new Pair(child_x, child_y));
            }
        }

        }
}

