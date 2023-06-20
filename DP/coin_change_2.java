class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;

        int [][] dp = new int [n+5][10000];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++) dp[i][j] = -1;
        }

        // Base Cases
        for(int ind=0; ind<n; ind++) dp[ind][0] = 1;
        for(int val_left=0; val_left<=amount; val_left++){
            if(val_left % coins[0] == 0) dp[0][val_left] = 1;
            else dp[0][val_left] = 0;
        }

        for(int ind=1; ind<n; ind++){
            for(int val_left = 0; val_left<=amount; val_left++){

                int nottake = dp[ind-1][val_left];

                int take = 0;
                if(val_left-coins[ind] >= 0){
                    take = dp[ind][val_left-coins[ind]]; 
                }

                dp[ind][val_left] = (take + nottake);

            }
        }

        // int ans = func(n-1, amount, coins, dp);
        int ans = dp[n-1][amount];
        return ans;
    }

    static int func(int ind, int val_left, int [] coins, int [][] dp){

        if(val_left == 0) return 1;
        if(ind == 0){
            if(val_left % coins[0] == 0) return 1;
            else return 0;
        }

        if(dp[ind][val_left] != -1) return dp[ind][val_left];

        int nottake = func(ind-1, val_left, coins, dp);

        int take = 0;
        if(val_left-coins[ind] >= 0){
            take = func(ind, val_left-coins[ind], coins, dp);
        }

        return dp[ind][val_left] = (take + nottake);
    }
}