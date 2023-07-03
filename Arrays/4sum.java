class Solution {
    public List<List<Integer>> fourSum(int[] nums, int ultimate_target) {
        int n = nums.length;
        Arrays.sort(nums);

        HashMap<List<Integer>, Integer> m = new HashMap<>();

        for(int i=0; i<n; i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
           
           // fix two elements at a time & perform 2sum problem
           for(int j=i+1; j<n; j++){
                long target = ultimate_target*1l - (nums[i] + nums[j])*1l;

                int left = j+1;
                int right = n-1;

                while(left < right){
                    
                    if((nums[left] + nums[right]) == target){
                        List<Integer> sub = new ArrayList<>();
                        sub.add(nums[i]);
                        sub.add(nums[j]);
                        sub.add(nums[right]);
                        sub.add(nums[left]);
                        Collections.sort(sub);
                        m.put(sub, 1);
                        // dont break as there can be more pairs with sum=target
                        left++;
                    }

                    else if((nums[left] + nums[right]) < target) left++;

                    else right--;
                }
           }
            
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(Map.Entry<List<Integer>, Integer>entry : m.entrySet()){
            ans.add(entry.getKey());
        }

        return ans;
    }
}