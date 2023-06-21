class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int [] nums2 = new int [n+2];
        nums2[0] = 1;
        for(int i=0; i<n; i++){
            nums2[i+1] = nums[i];
        }
        nums2[n+1] = 1;

        int [][] dp = new int [n+5][n+5];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++) dp[i][j] = -1;
        }

        int ans = func(1, n, nums2, dp);
        return ans;

    }

    static int func(int i, int j, int [] nums2, int [][] dp){

        if(i>j) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int max = Integer.MIN_VALUE;
        for(int ind=i; ind<=j; ind++){

            int coins_self = nums2[i-1] * nums2[ind] * nums2[j+1];
            int coins_parts = func(i, ind-1, nums2, dp) + func(ind+1, j, nums2, dp);

            int coins = coins_self + coins_parts;
            max = Math.max(max, coins);
        }

        return dp[i][j] = max;
    }
}