class Solution {
    public int longestOnes(int[] nums, int k) {

        int n = nums.length;
        int low = 0;
        int high = 0;
        int tolerance = 0;
        int max = 0;

        while(high < n){
            if(nums[high]==0){
                tolerance++;
            }
            if(tolerance > k){
                while(tolerance > k){
                    if(nums[low]==0){
                        tolerance--;
                    }
                    low++;
                }
            }

            max = Math.max(max, high-low+1);
            high++;
        }

        return max;
        
        // int n = nums.length;
        // Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        // int cnt = 0;
        // int max = Integer.MIN_VALUE;
        // int low = 0;
        // int high = 0;

        // while(high < n){
        //     if(nums[low]==1){
        //         m.put(low, 0);
        //     }
        //     if(nums[high] == 1){
        //         high++;
        //         cnt++;
        //         //max = Math.max(max, cnt);
        //         m.put(low, cnt);
        //     }
        //     else{
        //         while(high<n && nums[high]!=1){
        //             high++;
        //             cnt = 0;
        //         }
        //         low = high;
        //     }
        //     System.out.println("low " + low + " high " + high + " count " + cnt);
        //     // max = Math.max(max, cnt);
        //     // m.put(low, max);
        // }

        // for(Map.Entry<Integer, Integer> entry: m.entrySet()){
        //     System.out.println(entry.getKey() + " " + entry.getValue());
        // }

        // return -1;
        
    }
}