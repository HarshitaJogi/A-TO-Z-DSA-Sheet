class Solution {
    public int minCut(String s) {
        int n = s.length();

        int [] dp = new int [100000];
        Arrays.fill(dp, 0);

        for(int ind=n-1; ind>=0; ind--){

            int minCost = Integer.MAX_VALUE;
            String temp = "";

            for(int i=ind; i<s.length(); i++){
                temp += s.charAt(i);
                if(isPalindrome(temp) == true){
                    // 1 is self cost
                    int cost = 1 + dp[i+1];    // self cost + cost of other half
                    minCost = Math.min(minCost, cost);
                }
            }

            dp[ind] = minCost;

        }

        // int ans = func(0, s, dp);
        int ans = dp[0];
        return ans-1;
    }

    static int func(int ind, String s, int [] dp){

        if(ind == s.length()) return 0;

        if(dp[ind] != -1) return dp[ind];

        int minCost = Integer.MAX_VALUE;
        String temp = "";

        for(int i=ind; i<s.length(); i++){
            temp += s.charAt(i);
            if(isPalindrome(temp) == true){
                // 1 is self cost
                int cost = 1 + func(i+1, s, dp);    // self cost + cost of other half
                minCost = Math.min(minCost, cost);
            }
        }

        return dp[ind] = minCost;
    }

    static boolean isPalindrome(String s){
        int i=0;
        int j=s.length()-1;

        while(i<j){
            if(s.charAt(i) != s.charAt(j)) return false;
            else{
                i++;
                j--;
            }
        }

        return true;
    }
}