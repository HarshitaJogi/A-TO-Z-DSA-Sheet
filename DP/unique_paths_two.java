class Solution {
    static int [][] dp = new int [105][105];
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j] = -1;
            }
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int ans = func(m, n, 0, 0, obstacleGrid);
        return ans;

    }


    static int func(int m, int n, int row, int col, int [][] obstacleGrid){


        if(row >= m || col >= n) return 0;
        else if(obstacleGrid[row][col] == 1) return 0;
        else if(row == m-1 && col == n-1) return 1;
        else if(dp[row][col] != -1) return dp[row][col];
        
        // way 1
        int ans = func(m, n, row+1, col, obstacleGrid);

        // way 2
        ans += func(m, n, row, col+1, obstacleGrid);

        return dp[row][col]=ans;

    }
}