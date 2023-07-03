class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;

        // fix one number, then we will get a 2 sum problem
        Arrays.sort(nums);
        HashMap<List<Integer>, Integer> m = new HashMap<>();   // bec we wont want duplicate lists

        for(int i=0; i<n; i++){
            if(i>0 && nums[i]==nums[i-1]) continue;

            int curr = nums[i];
            int target = -curr;
            
            // two sum
            int left = i+1;
            int right = n-1;

            while(left < right){
                if(nums[left] + nums[right] == target){
                    List<Integer> sub = new ArrayList<Integer>();
                    sub.add(-target);
                    sub.add(nums[left]);
                    sub.add(nums[right]);
                    m.put(sub, 1);
                    // we dont break here bec there can be another pair of numbers with the same target
                    left++;
                }

                if(nums[left] + nums[right] < target){
                    left++;
                }

                else right--;
            }
        }


        List<List<Integer>> ans = new ArrayList<>();
        for(Map.Entry<List<Integer>, Integer> entry: m.entrySet()){
            List<Integer> curr = entry.getKey();
            ans.add(curr);
        }

        return ans;
        
    }
}








