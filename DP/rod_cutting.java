class Solution{
    public int cutRod(int price[], int n) {
        //code here
        int [] wt = new int [n+1];
        for(int i=0; i<n; i++){
            wt[i] = i+1;
        }
        
        int [][] dp = new int [n+5][n+5];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j] = 0;
            }
        }
        
        
        // Tabular Form
        
        for(int i=0; i<=n; i++){
            dp[0][i] = (i/wt[0])*price[0];
        }
        
        for(int index=1; index<n; index++){
            for(int wt_left=0; wt_left<=n; wt_left++){
                
                // do not pick
                int dontpick = dp[index-1][wt_left];
                
                // pick
                int pick = 0;
                if(wt_left - wt[index] >= 0){
                    pick = dp[index][wt_left-wt[index]] + price[index];
                }
                
                dp[index][wt_left] = Math.max(dontpick, pick);
            }
        }
        
        return dp[n-1][n];
        
        // int ans = func(price, wt, n-1, n, dp);
        // return ans;
    }
    
    // static int func(int [] price, int [] wt, int index, int wt_left, int [][] dp){
        
    //     if(index < 0) return 0;
        
    //     if(wt_left == 0) return 0;
        
    //     if(dp[index][wt_left] != -1) return dp[index][wt_left];
        
    //     // do not pick
    //     int dontpick = func(price, wt, index-1, wt_left, dp);
        
    //     // pick
    //     int pick = 0;
    //     if(wt_left - wt[index] >= 0){
    //         pick = func(price, wt, index, wt_left - wt[index], dp) + price[index];
    //     }
        
    //     return dp[index][wt_left] = Math.max(dontpick, pick);
    // }
}