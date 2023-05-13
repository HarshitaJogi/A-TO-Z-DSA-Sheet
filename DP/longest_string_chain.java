class Solution {
    public int longestStrChain(String[] words) {
    
        int n = words.length;
        
        // to sort array acc to its length
        Arrays.sort(words, Comparator.comparing(s->s.length()));

        // for(String s: words) System.out.print(s + " ");
        // System.out.println();

        int [] dp = new int [n];
        Arrays.fill(dp, 1);

        int maxi = 1;

        for(int index=1; index<n; index++){
            for(int prev_index = 0; prev_index<index; prev_index++){
                if((compare(words[index], words[prev_index])) && (dp[index]<dp[prev_index]+1)){
                    dp[index] = dp[prev_index] + 1;
                }
            }

            if(dp[index] > maxi){
                maxi = dp[index];
            }
        }

        return maxi;
    }

    static boolean compare(String s1, String s2){
        if(s1.length() != s2.length()+1) return false;

        int first = 0;
        int second = 0;

        while(first < s1.length()){
            if(second < s2.length() && (s1.charAt(first) == s2.charAt(second))){
                first++;
                second++;
            }
            else{
                first++;
            }
        }

        if(first == s1.length() && second == s2.length()){
            // System.out.println("first: " + s1 + " second: " + s2);
            return true;
        } 
        else return false;
    }
    
}