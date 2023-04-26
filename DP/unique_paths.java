class Solution {
    static int [][] dp = new int [110][110];
    public int uniquePaths(int m, int n) {
        // int N = n + m - 2;
        // int r = m - 1;
        // double res = 1;
        
        // for(int i=1; i<=r; i++){
        //     res = res*(N-r+i)/i;
        // }
        // return (int)res;

        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j] = -1;
            }
        }

        int ans = func(m, n, 0, 0);
        return ans;
        
    }

    static int func(int m, int n, int row, int col){


        if(row >= m || col >= n) return 0;
        else if(row == m-1 && col == n-1) return 1;
        else if(dp[row][col] != -1) return dp[row][col];
        
        // way 1
        int ans = func(m, n, row+1, col);

        // way 2
        ans += func(m, n, row, col+1);

        return dp[row][col]=ans;
    }
}