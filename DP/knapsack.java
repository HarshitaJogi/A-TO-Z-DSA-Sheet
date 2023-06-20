class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int [][] dp = new int [1005][1005];
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         for(int i=0; i<dp.length; i++){
             for(int j=0; j<dp[0].length; j++){
                 dp[i][j] = 0;
             }
         }
         
         // Base case:
         for(int ind=0; ind<n; ind++){
             dp[ind][0] = 0;
         }
         
         for(int ind=n-1; ind>=0; ind--){
             for(int wt_left = 0; wt_left <= W; wt_left++){
                 
                int nottake = dp[ind+1][wt_left]; 
        
                int take = 0;
                if(wt_left-wt[ind] >= 0){
                    take = dp[ind+1][wt_left-wt[ind]] + val[ind];
                }
                
                dp[ind][wt_left] = Math.max(nottake, take);
             }
         }
         
        //  int ans = knapsack(0, W, wt, val, n, dp);
        int ans = dp[0][W];
         return ans;
    }
    
    static int knapsack(int ind, int wt_left, int [] wt, int [] val, int n, int [][] dp){
        
        if(ind >= n) return 0;
        if(wt_left == 0) return 0;
        
        if(dp[ind][wt_left] != -1) return dp[ind][wt_left];
        
        int nottake = knapsack(ind+1, wt_left, wt, val, n, dp);
        
        int take = 0;
        if(wt_left-wt[ind] >= 0){
            take = knapsack(ind+1, wt_left-wt[ind], wt, val, n, dp) + val[ind];
        }
        
        return dp[ind][wt_left] = Math.max(nottake, take);
    }