class Solution {
    public int minInsertions(String s) {
        
        int n = s.length();

        // building the reverse string
        String rev = "";
        for(int i=n-1; i>=0; i--){
            rev += s.charAt(i);
        }

        int [][] dp = new int [n+5][n+5];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++) dp[i][j] = 0;
        }

        for(int p1=1; p1<=n; p1++){
            for(int p2=1; p2<=n; p2++){

                if(s.charAt(p1-1) == rev.charAt(p2-1)){
                    dp[p1][p2] = 1 + dp[p1-1][p2-1];
                }
                else{
                    dp[p1][p2] = 0 + Math.max(dp[p1-1][p2], dp[p1][p2-1]);
                }
            }
        }

        int palindromic_length = dp[n][n];
        int ans = n - palindromic_length;
        return ans;
    }
}