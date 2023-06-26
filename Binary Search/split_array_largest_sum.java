class Solution {
    public int splitArray(int[] nums, int k) {
        if(nums.length == 1) return nums[0];

        int low = 1;
        int high = 0;
        for(int i: nums) high += i;

        int ans = Integer.MAX_VALUE;
        while(low <= high){
            int mid = low + (high-low)/2;

            if(isPossible(mid, nums, k) == true){
                high = mid-1;
                ans = Math.min(ans, mid);
            }
            else{
                low = mid+1;
            }
        }

        return ans;
    }

    static boolean isPossible(int mid, int [] nums, int k){
        for(int i=0; i<nums.length; i++){
            if(nums[i]>mid) return false;
        }

        int curr = 0;
        int divisions = 1;

        for(int i=0; i<nums.length; i++){
            curr += nums[i];
            if(curr > mid){
                divisions++;
                curr = nums[i];
            }
        }

        if(divisions <= k) return true;
        else return false;
    }
}