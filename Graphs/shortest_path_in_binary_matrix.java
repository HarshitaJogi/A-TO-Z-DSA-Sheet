class Solution {
    static int [][] level = new int [110][110];
    static boolean [][] vis = new boolean [110][110];
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        if(grid[0][0] == 1) return -1;
        
        int INF = (int)1E9;
        for(int i=0; i<level.length; i++){
            for(int j=0; j<level[0].length; j++){
                level[i][j] = INF;
            }
        }

        for(int i=0; i<vis.length; i++){
            for(int j=0; j<vis[0].length; j++){
                vis[i][j] = false;
            }
        }

        bfs(grid);

        int n = grid.length;

        if(level[n-1][n-1] == INF) return -1;
        

        return level[n-1][n-1];
    }

    static void bfs (int [][] grid){

        int n = grid.length;
        
        level[0][0] = 1;
        vis[0][0] = true;
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(new Pair(0,0));

        while(!q.isEmpty()){
            Pair <Integer, Integer> curr = q.poll();
            int curr_x = curr.getKey();
            int curr_y = curr.getValue();

            int [] child_coord_x = {0, 0, 1, -1, 1, 1, -1, -1};
            int [] child_coord_y = {1, -1, 0, 0, 1, -1, 1, -1};

            for(int i=0; i<8; i++){
                int child_x = curr_x + child_coord_x[i];
                int child_y = curr_y + child_coord_y[i];

                if(child_x <0 || child_x >=n || child_y<0 || child_y >=n) continue;
                if(grid[child_x][child_y] == 1) continue;
                if(level[child_x][child_y] < level[curr_x][curr_y] + 1) continue;
                if(vis[child_x][child_y] == true) continue;
                
                q.add(new Pair(child_x, child_y));
                vis[child_x][child_y] = true;
                level[child_x][child_y] = level[curr_x][curr_y] + 1;
            }
        }

    }
}