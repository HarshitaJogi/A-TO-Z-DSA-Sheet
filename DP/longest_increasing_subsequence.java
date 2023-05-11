class Solution {

    public int lengthOfLIS(int[] nums) {
        
        // int [] dp = new int [nums.length];
        // Arrays.fill(dp, -1);

        // int ans = 0;
        // for(int i=0; i<nums.length; i++){
        //     ans = Math.max(ans, func(nums, i, dp));
        // }

        // TABULAR FORM
        // for(int ind=0; ind<nums.length; ind++){
        //     int ans = 1;
        //     for(int i=0; i<ind; i++){
        //         if(nums[ind]>nums[i]){
        //             ans =  Math.max(ans, dp[i]+1);   
        //         }
        //     }
        //     dp[ind] = ans;
        // }

        // int ans = 0;
        // for(int i: dp) ans = Math.max(ans, i);

        // return ans;



        // int [][] dp = new int [nums.length+1][nums.length+1];
        // for(int i=0; i<dp.length; i++){
        //     for(int j=0; j<dp[0].length; j++){
        //         dp[i][j] = -1;
        //     }
        // }
        
        // int ans = lis(nums, 0, -1, dp);
        // return ans;

        // STRIVER TABULAR

        int [][] dp = new int [nums.length+1][nums.length+1];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j] = 0;
            }
        }

        for(int index = nums.length-1; index>=0; index--){
            for(int prev_index = index-1; prev_index>=-1; prev_index--){

                // dont take
                int not_take =  dp[index+1][prev_index+1];  

                // take
                int take = 0;
                if(prev_index == -1 || nums[index]>nums[prev_index]){
                    take = dp[index+1][index+1] + 1;  
                }

                dp[index][prev_index+1] = Math.max(not_take, take);
            }
        }

        return dp[0][0];

    }


    // STRIVER SOLUTION
    // static int lis(int [] nums, int index, int prev_index, int [][] dp){

    //     if(index == nums.length) return 0;

    //     if(dp[index][prev_index+1] != -1) return dp[index][prev_index+1];

    //     // dont take
    //     int not_take = lis(nums, index+1, prev_index, dp);

    //     // take
    //     int take = 0;
    //     if(prev_index == -1 || nums[index]>nums[prev_index]){
    //         take = lis(nums, index+1, index, dp) + 1;
    //     }

    //     return dp[index][prev_index+1] = Math.max(not_take, take);
    // }


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
