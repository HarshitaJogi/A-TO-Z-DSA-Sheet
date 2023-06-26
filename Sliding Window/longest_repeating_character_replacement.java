class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();

        Map<Character, Integer> m = new HashMap<>();
        int left = 0;
        int right = 0;
        int maxLength = 0;

        while(right<n){
            char c = s.charAt(right);

            // put in map
            if(m.containsKey(c)){
                m.put(c, m.get(c)+1);
            }
            else{
                m.put(c, 1);
            }

            // check if window is valid

            // find freq of most repeating character
            int maxFreq = 0;
            for(Map.Entry<Character, Integer> entry: m.entrySet()){
                maxFreq = Math.max(maxFreq, entry.getValue());
            }

            int sizeOfWindow = right - left + 1;
            

            // replacements to make will be sizeOfWindow - maxFreq
            while(sizeOfWindow - maxFreq > k){
                    // decrement frequency of left character
                    m.put(s.charAt(left), m.get(s.charAt(left))-1);
                    left++;

                    for(Map.Entry<Character, Integer> entry: m.entrySet()){
                        maxFreq = Math.max(maxFreq, entry.getValue());
                    }

                    sizeOfWindow = right - left + 1;

            }
            

            int curr_length = right - left + 1;
            maxLength = Math.max(maxLength, curr_length);
            right++;
        }

        return maxLength;
        
    }
}



















