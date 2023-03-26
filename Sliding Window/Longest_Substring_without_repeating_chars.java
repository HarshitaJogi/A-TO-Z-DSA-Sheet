class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = s.length();
        if(l==0) return 0;

        int low = 0;
        int high = 0;
        int len = 0;
        int max = Integer.MIN_VALUE;
        Map<Character, Integer> m = new HashMap<Character, Integer>();

        while(high<l){

            if(!m.containsKey(s.charAt(high))){
                //cnt++;
                m.put(s.charAt(high), 1);
                high++;
            }
            else{
                while(m.containsKey(s.charAt(high)) && low<=high){
                    //cnt--;
                    m.remove(s.charAt(low));
                    low++;
                }
            }

            max = Math.max(max, (high-low));
        }

        return max;



        // while(high<l){
        //     if(s.charAt(low) != s.charAt(high)){
        //         high++;
        //         cnt++;
        //         max = Math.max(max, cnt);
        //     }
        //     else{
        //         low = high;
        //         high++;
        //         cnt = 1;
        //     }
        // }

        // return cnt;
    }
}
