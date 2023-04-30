class Solution {
    static long [] dp = new long [(int)1E5];
    public int coinChange(int[] coins, int amount) {
        // int ans = Integer.MAX_VALUE;

        Arrays.fill(dp, -1);
        // long ans1 = func(coins, amount);

        // if(ans1 == Integer.MAX_VALUE) return -1;
        // ans = (int)ans1;
        // System.out.println(ans1);

        // tabular form
        dp[0] = 0l;
        for(int amt_left = 1; amt_left <= amount; amt_left++){

            long ans = Integer.MAX_VALUE;
            for(int coin: coins){
                if(amt_left - coin >= 0){
                    ans =  Math.min(ans, dp[amt_left-coin]+1); 
                }
            }

            dp[amt_left] = ans;
        }

        int ans = (int)dp[amount];

        if(ans == Integer.MAX_VALUE) return -1;

        return ans;
    }


    // static long func(int [] coins, int amt_left){

    //     if(amt_left == 0) return 0l; 
        
    //     if(dp[amt_left] != -1) return dp[amt_left];

    //     long ans = Integer.MAX_VALUE;
    //     for(int coin: coins){
    //         if(amt_left - coin >= 0){
    //             ans = Math.min(ans, func(coins, amt_left-coin) + 1);
    //         }
    //     }

    //     return dp[amt_left] = ans;
    // }

    
}