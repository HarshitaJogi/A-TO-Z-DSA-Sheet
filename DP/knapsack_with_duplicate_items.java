class Solution{
    static int knapSack(int N, int W, int val[], int wt[])
    {
        // code here
        int [][] dp = new int [N+5][W+5];
        
        // for(int i=0; i<dp.length; i++){
        //     for(int j=0; j<dp[0].length; j++){
        //         dp[i][j] = -1;
        //     }
        // }
        
        
        // TABULAR FORM
        
        // Base cases:
        // If ind==0, it means we are at the first item. Now, in an 
        // unbounded knapsack we can pick an item any number of times we want. 
        // As there is only one item left, we will pick for W/wt[0] times 
        // because we ultimately want to maximize the value of items 
        // while respecting the constraint of weight of the knapsack. 
        // The value added will be the product of the number of items picked 
        // and value of the indi
        
        for(int i=wt[0]; i<=W; i++){
            dp[0][i] = (int)(i/wt[0])*(val[0]);
        }
        
        
        for(int index=1; index<N; index++){
            for(int wt_left=0; wt_left<=W; wt_left++){
                
                // do not pick
                int dontpick = dp[index-1][wt_left];
                
                // pick
                int pick = 0;
                if(wt_left - wt[index] >= 0){
                    pick = dp[index][wt_left-wt[index]] + val[index];
                }
                
                
                dp[index][wt_left] = Math.max(dontpick, pick);
            }
        }
        
        // int ans = knapsack(N-1, W, val, wt, dp);
        // return ans;
        
        return dp[N-1][W];
        
    }
    
    // static int knapsack(int index, int wt_left, int [] val, int [] wt, int [][] dp){
        
    //     if(index < 0) return 0;
        
    //     if(wt_left == 0) return 0;
        
    //     if(dp[index][wt_left] != -1) return dp[index][wt_left];
        
    //     // do not pick
    //     int dontpick = knapsack(index-1, wt_left, val, wt, dp);
        
    //     // pick
    //     int pick = 0;
    //     if(wt_left - wt[index] >= 0){
    //         pick = knapsack(index, wt_left-wt[index], val, wt, dp) + val[index];
    //     }
        
        
    //     return dp[index][wt_left] = Math.max(dontpick, pick);
    // }
}