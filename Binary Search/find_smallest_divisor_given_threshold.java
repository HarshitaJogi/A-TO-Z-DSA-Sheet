class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = Integer.MAX_VALUE;

        while(low<=high){
            int mid = low + (high-low)/2;

            int curr_sum = 0;
            for(int i=0; i<nums.length; i++){
                // curr_sum += (nums[i]/mid)+1;
                curr_sum += (nums[i] + mid -1)/mid;
            }

            if(curr_sum <= threshold){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return low;
    }
}