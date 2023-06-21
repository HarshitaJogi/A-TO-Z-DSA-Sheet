class Solution{
    static int matrixMultiplication(int N, int arr[])
    {   
        int [][] dp = new int [N+5][N+5];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++) dp[i][j] = 0;
        }
        
        // Base Case
        for(int i=1; i<N; i++){
            dp[i][i] = 0;
        }
        
        for(int i=N-1; i>=1; i--){
            for(int j=i+1; j<N; j++){
                
                int min = Integer.MAX_VALUE;
                for(int k=i; k<j; k++){
                    int noOfOperationsOfItself = arr[i-1] * arr[k] * arr[j];
                    int noOfOperationsAfterDividing = dp[i][k] +  dp[k+1][j];
                    int steps = noOfOperationsOfItself + noOfOperationsAfterDividing;
                    min = Math.min(min, steps);
                }
                
                dp[i][j] = min;
                
            }
        }
        
        // int ans = func(1, N-1, arr, dp);
        int ans = dp[1][N-1];
        return ans;
    }
    
    // returns min no of operations needed to multiply from matrix i to j
    static int func(int i, int j, int [] arr, int [][] dp){
        
        // if after dividing we get the metrix itself
        if(i == j) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        int min = Integer.MAX_VALUE;
        for(int k=i; k<j; k++){
            int noOfOperationsOfItself = arr[i-1] * arr[k] * arr[j];
            int noOfOperationsAfterDividing = func(i, k, arr, dp) + func(k+1, j, arr, dp);
            int steps = noOfOperationsOfItself + noOfOperationsAfterDividing;
            min = Math.min(min, steps);
        }
        
        return dp[i][j] = min;
    }
}