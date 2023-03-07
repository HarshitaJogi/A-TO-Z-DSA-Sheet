class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        int floor = -1;

        while(low<=high){
            int mid = low + (high-low)/2;

            if(target == nums[mid]) return mid;

            if(nums[mid]<target){
                floor = mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }

        return floor+1;
    }
}