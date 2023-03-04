class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int xor = 0;
        for(int i=0; i<nums.length; i++){
            xor = xor ^ nums[i];
        }
        return xor;
    }
}