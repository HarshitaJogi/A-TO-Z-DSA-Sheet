class Solution {
    public static int totalFruits(int N, int[] fruits) {
        
        int left = 0;
        int right = 0;
        int ans = 0;
        
        Map<Integer, Integer> m = new HashMap<>();
        
        while(right<N){
            int curr = fruits[right];
            
            if(m.containsKey(curr)){
                m.put(curr, m.get(curr)+1);
            }
            else{
                m.put(curr, 1);
            }
            

          
            while(m.size()>2){
                // keep reducing freq of left till it becomes 0
                m.put(fruits[left], m.get(fruits[left])-1);
                
                if(m.get(fruits[left]) == 0){
                    m.remove(fruits[left]);
                }
                
                left++;
            }
            
            
            int curr_length = right - left + 1;
            ans = Math.max(ans, curr_length);
            right++;
        }
        
        return ans;
    }
}