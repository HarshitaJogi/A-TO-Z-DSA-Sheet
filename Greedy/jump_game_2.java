class Solution {
    // static int [] dp = new int [10005]
    public int jump(int[] nums) {
        int n = nums.length;
        int [] dp = new int [10005];
        Arrays.fill(dp, -1);
        int ans = func(nums, 0, dp);
        // System.out.println(ans);
        return ans;
    }

    static int func(int [] nums, int index, int [] dp){

        // if(index < 0) return 0;
        if(index >= nums.length-1) return 0;

        if(dp[index] != -1) return dp[index];

        //just like frog jump 2 k acts nums[index]
        int ans = 100000;
        for(int i=1; i<=nums[index]; i++){
            // if(index-i>=0){
                ans = Math.min(ans, func(nums, index+i, dp)+1);
            // }
            
        }

        return dp[index] = ans;
    }
}