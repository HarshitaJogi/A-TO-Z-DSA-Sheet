class Solution{
    int longestCommonSubstr(String text1, String text2, int n, int m){
        // code here

        int [][] dp = new int [n+1][m+1];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j] = -1;
            }
        }

        for(int i=0; i<=n; i++){
            dp[i][0] = 0;
        }
        for(int j=0; j<=m; j++){
            dp[0][j] = 0;
        }
        
        int ans = 0;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){

                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    // System.out.println(dp[i][j]);
                    ans = Math.max(ans, dp[i][j]);
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }

        return ans;
    }
    
    
}