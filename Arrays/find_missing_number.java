class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int missing = -1;
        int l = nums.length;

        // for(int i=0; i<nums.length; i++){
        //     if(nums[i] != i){
        //         missing = i;
        //         break;
        //     }
        // }

        // if(missing == -1) return nums.length;
        // else return missing;

        int sum = 0;
        for(int i=0; i<l; i++){
            sum += nums[i];
        }

        int sum_n = l*(l+1)/2;

        missing = sum_n - sum;
        return missing;
    }
}