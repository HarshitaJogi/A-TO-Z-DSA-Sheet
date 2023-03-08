class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        // int index = -1;
        // for(int i=1; i<nums.length-1; i++){
        //     if(nums[i]>nums[i+1] && nums[i]>nums[i-1]){
        //         index = i;
        //         break;
        //     }
        // }

        // if(index==-1){
        //     if(nums[0]>nums[nums.length-1]) index = 0;
        //     else index = nums.length-1;
        // }

        if(n==1) return 0;
        if(n>1){
            if(nums[0]>nums[1]) return 0;
            else if(nums[n-1]>nums[n-2]) return n-1;
        } 
        
        
             int low = 1;
            int high = n-2;

            while(low<=high){
                int mid = low + (high - low)/2;

                if(nums[mid]>nums[mid+1] && nums[mid]>nums[mid-1]){
                    return mid;
                }

                else if(nums[mid]<nums[mid+1]){
                    low = mid + 1;
                }

                else if(nums[mid]<nums[mid-1]){
                    high = mid - 1;
                }
            }
        
       

        return -1;
    }
}