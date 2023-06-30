class Solution{
    static int M = (int)1E9 + 7;
    public static String betterString(String str1, String str2) {
        
        int count1 = countDistinct(str1);
        int count2 = countDistinct(str2);
        
        if(count2 > count1) return str2;
        else return str1;
    }
    
    static int countDistinct(String s){
        int n = s.length();
        
        int [] dp = new int [n+5];
        // every string has empty string as substring
        dp[0] = 1;
        
        // Sotres the last occurance of character with its index
        HashMap<Character, Integer> m = new HashMap<>();
        
        for(int i=1; i<=n; i++){
            char c = s.charAt(i-1);
            
            // if it has occured before
            if(m.containsKey(c)){
                int lastOccurance = m.get(c);
                
                dp[i] = ((2*dp[i-1])%M - (dp[lastOccurance-1])%M)%M;
            }
            else{
                dp[i] = 2*dp[i-1]%M;
            }
            
            m.put(c, i);
        }
        
        int ans = dp[n];
        if(ans<0) ans+=M;
        return ans;
        
    }
}
