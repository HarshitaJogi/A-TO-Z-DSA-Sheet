class Solution {
    public int longestkSubstr(String s, int k) {
        int n = s.length();
        int left = 0;
        int right = 0;
        int maxLen = -1;
        
        Map<Character, Integer> m = new HashMap<>();
        
        while(right < n){
            char c = s.charAt(right);
            
            if(m.containsKey(c)){
                m.put(c, m.get(c)+1);
            }
            else{
                m.put(c, 1);
            }
            
            // if we have less than k distinct characters
            if(m.size()<k){
                right++;
                continue;
            }
            
            // if we have more than k distinct characters
            while(m.size() > k){
                // reduce frequency of char at left
                m.put(s.charAt(left), m.get(s.charAt(left))-1);
                if(m.get(s.charAt(left)) == 0) m.remove(s.charAt(left));
                left++;
            }
            
            // if we have exactly k distinct characters
            int currLen = right-left+1;
            maxLen = Math.max(currLen, maxLen); 
            right++;
        }
        
        return maxLen;
    }
}