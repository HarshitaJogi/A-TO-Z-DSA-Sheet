class Solution {
    static int [][] dp = new int [1000][1000];

    public int minPathSum(int[][] grid) {
        
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j] = -1;
            }
        }

        int m = grid.length;
        int n = grid[0].length;
        int ans = min_Path(grid, m-1, n-1);
        return ans;
    }


    static int min_Path(int [][] grid, int x, int y){

        if(dp[x][y] != -1) return dp[x][y];
      
        if(x==0 && y==0) return grid[x][y];
        
        if(x==0)
           return min_Path(grid, x, y-1) + grid[x][y];

        if(y==0)
            return min_Path(grid, x-1, y) + grid[x][y];

        
        // dp[x][y] stores the min distance till x,y
        return dp[x][y] = Math.min(min_Path(grid, x-1, y)+grid[x][y]  ,  min_Path(grid, x, y-1)+grid[x][y]);

        
    }



  

    // static int func(int [][] grid, int x, int y){

    //     int rows = grid.length;
    //     int cols = grid[0].length;
        
    //     // if(x>=rows || y>=cols) return 0;

    //     int ans = Integer.MAX_VALUE;

    //     // go down
    //     if((x+1)<rows){
    //         ans = func(grid, x+1, y) + grid[x][y];
    //     }
        

    //     // go right
    //     if((y+1)<cols){
    //         ans = Math.min(ans, func(grid, x, y+1) + grid[x][y]);
    //     }
        

    //     return ans;
    // }
}