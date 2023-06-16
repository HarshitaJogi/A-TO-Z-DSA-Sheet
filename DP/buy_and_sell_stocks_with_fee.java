class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;

        int [][] dp = new int [n+5][5];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++) dp[i][j] = -1;
        }

        int ans = stock(prices, 1, 0, dp, fee);
        return ans;
    }

    static int stock(int [] prices, int buy, int index, int[][] dp, int fee){

        if(index == prices.length) return 0;

        if(dp[index][buy] != -1) return dp[index][buy];

        int profit = 0;
        if(buy == 1){
            int take = stock(prices, 0, index+1, dp, fee) - prices[index];   // buying
            int nottake = stock(prices, 1, index+1, dp, fee);   // not buying
            profit = Math.max(take, nottake);
        }

        else{
            int take = stock(prices, 1, index+1, dp, fee) + prices[index] - fee;    // selling
            int nottake = stock(prices, 0, index+1, dp, fee);   // not selling
            profit = Math.max(take, nottake);
        }

        return dp[index][buy] = profit;
    }
}