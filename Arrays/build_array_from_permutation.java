class Solution {
    public int[] buildArray(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();

        for(int i=0; i<n; i++){
            m.put(i, nums[i]);
        }

        for(int i=0; i<n; i++){
            int x = m.get(i);
            int y = m.get(x);
            //System.out.println(x + " " + y);
            nums[i] = y;
        }

        return nums;
    }
}