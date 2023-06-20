class Solution{
    public int cutRod(int price[], int n) {
        
        int [][] dp = new int[n+5][n+5];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++) dp[i][j] = 0;
        }
        
        for(int length_left=0; length_left<=n; length_left++){
            dp[1][length_left] = length_left*price[0];
        }
        
        for(int ind=1; ind<=n; ind++){
            for(int length_left=0; length_left<=n; length_left++){
                
                int nottake = dp[ind-1][length_left];
        
                int take = 0;
                if(length_left-ind >= 0){  // ind denotes length of removed rod
                    take = dp[ind][length_left-ind] + price[ind-1];  // bec 1 based indxing
                }
                
                dp[ind][length_left] = Math.max(take, nottake);
                
            }
        }
        
        // int ans = func(n, n, price, dp);
        int ans = dp[n][n];
        return ans;
    }
    
    static int func(int ind, int length_left, int [] price, int [][] dp){
        
        if(length_left == 0) return 0;
        if(ind == 1){
            return length_left*price[0];
        }
        
        if(dp[ind][length_left] != -1) return dp[ind][length_left];
        
        int nottake = func(ind-1, length_left, price, dp);
        
        int take = 0;
        if(length_left-ind >= 0){  // ind denotes length of removed rod
            take = func(ind, length_left-ind, price, dp) + price[ind-1];  // bec 1 based indxing
        }
        
        return dp[ind][length_left] = Math.max(take, nottake);
    }
}