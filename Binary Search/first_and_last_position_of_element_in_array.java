class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        int first=-1;
        int [] ans = new int [2];

        // for floor
        while(low<=high){
            int mid = low + (high-low)/2;

            if(nums[mid] == target){
                first = mid;
                high = mid-1;
            } 

            else if(nums[mid]>target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }

        // for ceil
        low = 0;
        high = n-1;
        int last = -1;
        while(low<=high){
            int mid = low + (high-low)/2;

            if(nums[mid] == target){
                last = mid;
                low = mid+1;
            }

            else if(nums[mid]<target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }

        ans[0] = first;
        ans[1] = last;

        return ans;


    }
}