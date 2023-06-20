class Solution{
    static int knapSack(int N, int W, int val[], int wt[]){
        
        int [][] dp = new int [N+5][W+5];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++) dp[i][j] = 0;
        }
        
        
        // Base cases
        for(int wt_left=0; wt_left<=W; wt_left++){
            if(wt_left != 0) dp[0][wt_left] = (wt_left/wt[0])*val[0];
            else dp[0][wt_left] = 0;
        }
        
        for(int ind=1; ind<N; ind++){
            for(int wt_left=0; wt_left<=W; wt_left++){
                
                int nottake = dp[ind-1][wt_left]; 
        
                int take = 0;
                if(wt_left-wt[ind] >= 0){
                    take = dp[ind][wt_left-wt[ind]] + val[ind];
                }
                
                dp[ind][wt_left] = Math.max(take, nottake);
                
            }
        }
        
        // int ans = func(N-1, W, val, wt, dp);
        int ans = dp[N-1][W];
        return ans;
    }
    
    static int func(int ind, int wt_left, int [] val, int [] wt, int [][] dp){
        
        if(wt_left == 0) return 0;
        if(ind == 0){
            if(wt_left != 0) return (wt_left/wt[0])*val[0];
            else return 0;
        }
        
        if(dp[ind][wt_left] != -1) return dp[ind][wt_left];
        
        int nottake = func(ind-1, wt_left, val, wt, dp);
        
        int take = 0;
        if(wt_left-wt[ind] >= 0){
            take = func(ind, wt_left-wt[ind], val, wt, dp) + val[ind];
        }
        
        return dp[ind][wt_left] = Math.max(take, nottake);
    }
}