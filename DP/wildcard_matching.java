class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        int [][] dp = new int [m+5][n+5];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++) dp[i][j] = -1;
        }

        boolean ans = func(s, p, m-1, n-1, dp);
        return ans;
    }

    static boolean func(String s, String p, int i, int j, int [][] dp){
        // both string and pattern got over
        if(i<0 && j<0) return true;
        // pattern over, string left
        if(i>=0 && j<0) return false;

        // pattern left, string over. Will return true for p="***...*" case only. Else false
        if(i<0 && j>=0){
            for(int k=0; k<=j; k++){
                if(p.charAt(k) != '*') return false;
            }
            return true;
        }

        if(dp[i][j] != -1){
            if(dp[i][j] == 1) return true;
            else return false;
        }

        // case for both characters matched
        if(s.charAt(i) == p.charAt(j) || p.charAt(j)=='?'){
            boolean ans = func(s, p, i-1, j-1, dp);
            if(ans == true) dp[i][j] = 1;
            else dp[i][j] = 0;
            return ans;
        }
        else if(p.charAt(j)=='*'){
            boolean star_is_null = func(s, p, i, j-1, dp);
            boolean match_char_with_star = func(s, p, i-1, j, dp);
            boolean ans = (star_is_null || match_char_with_star);
            if(ans == true) dp[i][j] = 1;
            else dp[i][j] = 0;
            return ans;
        }
        // we founf two unmatched letters
        else{
            boolean ans = false;
            dp[i][j] = 0;
            return ans;
        }
    }
}