class Solution {
    static int [][] dp = new int [1005][1005];
    public int longestCommonSubsequence(String text1, String text2) {

        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        int ans = lcs(text1, text2, text1.length()-1, text2.length()-1);
        return ans;
    }

    static int lcs(String text1, String text2, int i, int j){

        if(i<0 || j<0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        // remove 1 char from s1
        int ans = lcs(text1, text2, i-1, j);

        // reomove 1 char from s2
        ans = Math.max(ans, lcs(text1, text2, i, j-1));

        // remove 1 char from both
        int x = 0;
        if(text1.charAt(i) == text2.charAt(j)){
            x = 1;
        }
        ans = Math.max(ans, lcs(text1, text2, i-1, j-1)+x);

        return dp[i][j] = ans;
    }
}