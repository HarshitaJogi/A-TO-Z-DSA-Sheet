class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n-1;

        while(low<=high){
            int mid = low + (high-low)/2;

            if(nums[mid] == target) return mid;

            // check if left half is sorted:
            else if(nums[low]<=nums[mid]){
                // check if target lies in left half
                if(nums[low]<=target && nums[mid]>=target){
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }

            // if right half sorted
            else{
                // if target lies in right half
                if(nums[mid]<=target && nums[high]>=target){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}