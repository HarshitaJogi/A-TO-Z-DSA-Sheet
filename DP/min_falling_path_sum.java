class Solution {
    static int [][] dp = new int [200][200];
    public int minFallingPathSum(int[][] matrix) {

        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j] = -1;
            }
        }

        int m = matrix.length;
        int n = matrix[0].length;

        // to find the min of all paths of first row

        int ans = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            ans = Math.min(ans, func(matrix, 0, i, m, n));
        }
        return ans;
        
    }

    static int func(int [][] matrix, int x, int y, int m, int n){

        
        if(dp[x][y] != -1) return dp[x][y];
        if(x == m) return 0;

        // System.out.println(matrix[x][y]);
        int lower_right = Integer.MAX_VALUE;
        int lower_left = Integer.MAX_VALUE;
        
        // lower
        int lower = func(matrix, x+1, y, m, n) + matrix[x][y];

        // lower right
        if(y<n-1){
            lower_right = func(matrix, x+1, y+1, m, n) + matrix[x][y];
        }

        // lower left
        if(y>0){
            lower_left = func(matrix, x+1, y-1, m, n) + matrix[x][y];
        }

        // return the min of lower, lower_right, lower_left
        int min = Math.min(lower, lower_right);
        int ans = Math.min(min, lower_left);
        return dp[x][y] = ans;
    }
}