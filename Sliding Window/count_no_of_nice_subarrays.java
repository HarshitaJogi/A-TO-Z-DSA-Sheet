class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int ans = atMostKOdd(nums, k) - atMostKOdd(nums, k-1);
        return ans;
    }

    static int atMostKOdd(int [] nums, int k){
        int n = nums.length;
        int left = 0;
        int right = 0;
        int noOfSubArrays = 0;
        int noOfOdd = 0;

        while(right < n){
            if(nums[right]%2 != 0){
                noOfOdd++;
            }

            while(noOfOdd > k && left <= right){
                if(nums[left]%2 != 0) noOfOdd--;
                left++;
            }

            noOfSubArrays += right - left + 1;
            right++;
        }

        return noOfSubArrays;
    }
}