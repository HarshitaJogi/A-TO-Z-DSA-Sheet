class Solution {
    static int [][] dp = new int [300][20005];
    public boolean canPartition(int[] nums) {
        
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j] = -1;
            }
        }

        int total = 0;
        for(int i=0; i<nums.length; i++){
            total += nums[i];
        }
        if((total % 2) != 0) return false;
        int target = total/2;

        boolean ans = func(nums, target, 0, 0);
        return ans;
    }

    static boolean func(int [] nums, int target, int index, int currsum){

        if(dp[index][currsum] != -1){
            if(dp[index][currsum]==1) return true;
            else return false;
        }
        
        if(index == nums.length) return false;
        
        if(currsum > target) return false;

        if(currsum == target) return true;
        
        
        // do not pick
        boolean ans = func(nums, target, index+1, currsum);

        // pick
        ans |= func(nums, target, index+1, currsum+nums[index]);
      
        if(ans == true) dp[index][currsum] = 1;
        else dp[index][currsum] = 0;

        return ans;
    }
}