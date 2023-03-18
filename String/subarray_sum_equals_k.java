class Solution {
    public int subarraySum(int[] nums, int k) {
        
        int ans = 0;
        int n = nums.length;
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        int [] prefix = new int [n];

        prefix[0] = nums[0];
        for(int i=1; i<n; i++){
            prefix[i] = nums[i] + prefix[i-1];
        }

        for(int i=0; i<n; i++){

            if(prefix[i] == k) ans++;

            if(m.containsKey(prefix[i] - k)){
                int freq = m.get(prefix[i]-k);
                ans += freq;
            }
            //m.put(prefix[i], i);
            if(m.containsKey(prefix[i])){
                m.put(prefix[i], m.get(prefix[i])+1);
            }
            else{
                m.put(prefix[i], 1);
            }
        }
        
        
        return ans;
        
        
        
        // int n = nums.length;
        // int count = 0;

        // for(int i=0; i<n; i++){
        //     int sum = nums[i];
        //     if(sum == k) count++;
        //     for(int j=i+1; j<n; j++){
        //             //if(sum == k) break;
        //             sum += nums[j];
        //             if(sum == k) count++;
        //             //System.out.println(sum);
        //             //if(sum>k) break;
        //     }
        // }

        // return count;
    }
}