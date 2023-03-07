class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        //Arrays.sort(nums);

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i=0; i<n; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
            }
            else map.put(nums[i], 1);
        }

        // for(int i=0; i<map.size(); i++){
        //     if(map.get(i) > n/3){
        //         ans.add(map.getKey(i));
        //     }
        // }
        // for (int entry : map.values()) {
        //     if (entry > n/3) {
        //     ans.add(map.getKey(entry));
        // }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            System.out.println(entry.getValue());
            if(entry.getValue()>n/3){
                ans.add(entry.getKey());
            }
        }

        
    return ans;
    }
    

}