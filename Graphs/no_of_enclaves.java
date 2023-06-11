class Solution {
    public int numEnclaves(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;

        boolean [][] vis = new boolean [m][n];

        // traversing first row
        for(int i=0; i<n; i++){
            if(vis[0][i] == true) continue;
            if(grid[0][i] == 1){
                dfs(grid, vis, 0, i);
            }
        }

        // traversing first col
        for(int i=0; i<m; i++){
            if(vis[i][0] == true) continue;
            if(grid[i][0] == 1){
                dfs(grid, vis, i, 0);
            }
        }

        // traversing last row
        for(int i=0; i<n; i++){
            if(vis[m-1][i] == true) continue;
            if(grid[m-1][i] == 1){
                dfs(grid, vis, m-1, i);
            }
        }

        // traversing last col
        for(int i=0; i<m; i++){
            if(vis[i][n-1] == true) continue;
            if(grid[i][n-1] == 1){
                dfs(grid, vis, i, n-1);
            }
        }

        int ans = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    if(vis[i][j] == false) ans++;
                }
            }
        }

        return ans;
    }

    static void dfs(int [][] grid, boolean [][] vis, int row, int col){
        int m = grid.length;
        int n = grid[0].length;

        vis[row][col] = true;

        int [] x = {0, 0, 1, -1};
        int [] y = {1, -1, 0, 0};

        for(int i=0; i<4; i++){
            int child_x = row + x[i];
            int child_y = col + y[i];

            if(child_x>=m || child_x<0 || child_y>=n || child_y<0) continue;
            if(vis[child_x][child_y] == true) continue;
            if(grid[child_x][child_y] != 1) continue;

            dfs(grid, vis, child_x, child_y);
        }
    }
}