class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        for(int i=0; i<(1<<n); i++){
            int curr = i;
            List<Integer> l = new ArrayList<Integer>();
            for(int j=0; j<31; j++){
                if(((curr>>j)&1)!=0){
                    l.add(nums[j]);
                }
            }
            ans.add(l);
        }

        return ans;
    }
}