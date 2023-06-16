class Solution {
    
    public int maxProfit(int[] prices) {

        int n = prices.length;

        int [][] dp = new int [n+5][5];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++) dp[i][j] = 0;
        }
        

        // int ans = stock(prices, 1, 0, dp);

        // TABULAR (WITHOUT SPACE OPTI)
        // for(int ind = n-1; ind>=0; ind--){
        //     for(int buy = 0; buy <= 1; buy++){
        //         int profit = 0;
        //         if(buy == 1){
        //             int take = dp[ind+1][0] - prices[ind];   // buying
        //             int nottake = dp[ind+1][1];   // not buying
        //             profit = Math.max(take, nottake);
        //         }

        //         else{
        //             int take = dp[ind+1][1] + prices[ind];    // selling
        //             int nottake = dp[ind+1][0];   // not selling
        //             profit = Math.max(take, nottake);
        //         }

        //         dp[ind][buy] = profit;
        //     }
        // }


        // WITH SPACE OPTI
        int [] ahead = new int [n+5];
        int [] curr = new int [n+5];

        for(int ind = n-1; ind>=0; ind--){
            for(int buy = 0; buy <= 1; buy++){
                int profit = 0;
                if(buy == 1){
                    int take = ahead[0] - prices[ind];   // buying
                    int nottake = ahead[1];   // not buying
                    profit = Math.max(take, nottake);
                }

                else{
                    int take = ahead[1] + prices[ind];    // selling
                    int nottake = ahead[0];   // not selling
                    profit = Math.max(take, nottake);
                }

                curr[buy] = profit;
            }
            ahead = curr;
        }




        return ahead[1];
    }

    // we can only buy a stock if we dont have anything previously bought.
    // we keep a flag called 'buy', where it tells us if we can buy the stock at index or not.
    // Buy = 1 -> we can buy
    // Buy = 0 -> we cannot buy

    // static int stock(int [] prices, int buy, int index, int[][] dp){

    //     if(index == prices.length) return 0;

    //     if(dp[index][buy] != -1) return dp[index][buy];

    //     int profit = 0;
    //     if(buy == 1){
    //         int take = stock(prices, 0, index+1, dp) - prices[index];   // buying
    //         int nottake = stock(prices, 1, index+1, dp);   // not buying
    //         profit = Math.max(take, nottake);
    //     }

    //     else{
    //         int take = stock(prices, 1, index+1, dp) + prices[index];    // selling
    //         int nottake = stock(prices, 0, index+1, dp);   // not selling
    //         profit = Math.max(take, nottake);
    //     }

    //     return dp[index][buy] = profit;
    // }
}