class Solution {
    public int maxProfit(int k, int[] prices) {
        
        int n = prices.length;
        int [][][] dp = new int [n+5][5][k+5];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                for(int z=0; z<dp[0][0].length; z++) dp[i][j][z] = 0;
            }
        }

        for(int ind = n-1; ind>=0; ind--){
            for(int buy=0; buy<=1; buy++){
                for(int cap=k; cap>0; cap--){

                    int profit = 0;
                    if(buy == 1){
                        int take = dp[ind+1][0][cap] - prices[ind];
                        int nottake = dp[ind+1][1][cap];
                        profit = Math.max(take, nottake);
                    }
                    else{
                        int take = dp[ind+1][1][cap-1] + prices[ind];
                        int nottake = dp[ind+1][0][cap];
                        profit = Math.max(take, nottake);
                    }

                    dp[ind][buy][cap] = profit;
                }
            }
        }

        // int ans = stocks(prices, 0, 1, k, dp);
        int ans = dp[0][1][k];
        return ans;
    }

    static int stocks(int [] prices, int ind, int buy, int cap, int [][][] dp){

        if(ind == prices.length) return 0;
        if(cap <= 0) return 0;

        if(dp[ind][buy][cap] != -1) return dp[ind][buy][cap];

        int profit = 0;
        if(buy == 1){
            int take = stocks(prices, ind+1, 0, cap, dp) - prices[ind];
            int nottake = stocks(prices, ind+1, 1, cap, dp);
            profit = Math.max(take, nottake);
        }
        else{
            int take = stocks(prices, ind+1, 1, cap-1, dp) + prices[ind];
            int nottake = stocks(prices, ind+1, 0, cap, dp);
            profit = Math.max(take, nottake);
        }

        return dp[ind][buy][cap] = profit;
    }
}