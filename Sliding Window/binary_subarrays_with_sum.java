class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;

// total of subarrays with sum goal = total of subarrays with atmost sum goal - total of subarrays with atmost sum goal-1
        int ans = atMost(goal, nums) - atMost(goal-1, nums);
        return ans;
    }

    static int atMost(int goal, int [] nums){
        int n = nums.length;

        int left = 0;
        int right = 0;
        int sum = 0;
        int noOfSubarrays = 0;

        while(right < n){
            sum += nums[right];

            while(sum > goal && left<=right){
                sum -= nums[left];
                left++;
            }

            noOfSubarrays += right - left + 1;
            right++;
        }

        return noOfSubarrays;
    }
}









// BRUTE FORCE
// for(int i=0; i<n; i++){
//     int curr = nums[i];
//     if(curr == goal) cnt++;
//     int sum = nums[i];
//     for(int j=i+1; j<n; j++){
//         sum += nums[j];
//         if(sum == goal){
//             cnt++;
//         }
//     }
// }

// return cnt;