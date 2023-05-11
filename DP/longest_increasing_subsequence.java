class Solution {

    public int lengthOfLIS(int[] nums) {
        
        int [] dp = new int [nums.length];
        Arrays.fill(dp, -1);

        // int ans = 0;
        // for(int i=0; i<nums.length; i++){
        //     ans = Math.max(ans, func(nums, i, dp));
        // }

        // TABULAR FORM
        for(int ind=0; ind<nums.length; ind++){
            int ans = 1;
            for(int i=0; i<ind; i++){
                if(nums[ind]>nums[i]){
                    ans =  Math.max(ans, dp[i]+1);   
                }
            }
            dp[ind] = ans;
        }

        int ans = 0;
        for(int i: dp) ans = Math.max(ans, i);

        return ans;
    }

    // static int func(int [] nums, int index, int [] dp){

    //     if(dp[index] != -1) return dp[index];

    //     int ans = 1;
    //     for(int i=0; i<index; i++){
    //         if(nums[index]>nums[i]){
    //             ans = Math.max(ans, func(nums, i, dp)+1);
    //         }
    //     }

    //     return dp[index] = ans;
    // }
}