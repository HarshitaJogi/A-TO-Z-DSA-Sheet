class Solution {
    int distinctSubsequences(String S) {
        
        int n = S.length();
        long M = (int)1E9 + 7;
        
        long [] dp = new long [n+5];
        
        // there will always be an empty string of length 0
        dp[0] = 1;
        
        // stores last occurance of letter with its index in d array
        HashMap<Character, Integer> elementIndex = new HashMap<>();
        
        for(int i=1; i<=n; i++){
            
            char c = S.charAt(i-1);
            
            // letter has occured before
            if(elementIndex.containsKey(c)){
                int last_occurance = elementIndex.get(c);
                dp[i] = ( (dp[i-1]%M * 2%M)%M - (dp[last_occurance-1])%M )%M;
            }
            // letter not occured before, this is the first occurance
            else{
                dp[i] = (dp[i-1]%M * 2%M)%M;
            }
            
            // update that char c last occured in dp array at index i
            elementIndex.put(c, i);
            
        }
        
        int ans = (int) dp[n];
        if(ans<0) ans += M;
        
        return ans;
    }
}