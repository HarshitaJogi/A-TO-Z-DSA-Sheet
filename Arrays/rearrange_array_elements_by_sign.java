class Solution {
    public int[] rearrangeArray(int[] nums) {
        
        int l = nums.length;
        
        int [] ans = new int [l];

        // for positive
        int k=0;
        for(int i=0; i<l; i++){
            if(nums[i]>0){
                ans[k] = nums[i];
                k += 2;
            }
        }

        // for negative
        int n = 1;
        for(int i=0; i<l; i++){
            if(nums[i]<0){
                ans[n] = nums[i];
                n += 2;
            }
        }

        return ans;
    }
}