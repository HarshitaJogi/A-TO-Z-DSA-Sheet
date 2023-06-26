class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int ans = atMost(nums, k) - atMost(nums, k-1);
        return ans;
    }

    static int atMost(int [] nums, int k){
        int n = nums.length;

        int left = 0;
        int right = 0;
        int noOfSub = 0;

        Map<Integer, Integer> m = new HashMap<Integer, Integer>();

        while(right < n){
            int curr = nums[right];

            // put in map
            if(m.containsKey(curr)){
                m.put(curr, m.get(curr)+1);
            }
            else{
                m.put(curr, 1);
            }


            while(m.size() > k){
                m.put(nums[left], m.get(nums[left])-1);
                if(m.get(nums[left]) == 0) m.remove(nums[left]);
                left++;
            }

            noOfSub += right - left + 1; 
            right++;
        }

        return noOfSub;
    }
}