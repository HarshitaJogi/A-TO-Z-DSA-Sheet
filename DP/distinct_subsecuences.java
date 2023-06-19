class Solution {
    public int numDistinct(String s, String t) {
        int s_len = s.length();
        int t_len = t.length();

        int [][] dp = new int [s_len+5][t_len+5];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++) dp[i][j] = 0;
        }

        // int ans = func(s, t, s.length()-1, t.length()-1, dp);

        // BASE CASES
        for(int p2=0; p2<dp[0].length; p2++){
            dp[0][p2] = 0;
        }

        for(int p1=0; p1<dp.length; p1++){
            dp[p1][0] = 1;
        }

        for(int p1=1; p1<=s.length(); p1++){
            for(int p2=1; p2<=t.length(); p2++){

                if(s.charAt(p1-1) == t.charAt(p2-1)){
                    // take the equal characters
                    int take = dp[p1-1][p2-1]; 
                    // dont take the equal characters
                    int nottake = dp[p1-1][p2];

                    dp[p1][p2] = take+nottake;
                }
                else{
                    dp[p1][p2] = dp[p1-1][p2]; 
                }
            }
        }

        // for(int i=0; i<=s_len; i++){
        //     for(int j=0; j<=t_len; j++) System.out.print(dp[i][j] + " ");
        //     System.out.println();
        // }


        return dp[s_len][t_len];
    }

    static int func(String s, String t, int p1, int p2, int [][] dp){
        // all letters of t were matched and found
        if(p2 < 0) return 1;
        // we reached the end of s but all letters of t not yet found
        if(p1 < 0) return 0;

        if(dp[p1][p2] != -1) return dp[p1][p2];

        if(s.charAt(p1) == t.charAt(p2)){
            // take the equal characters
            int take = func(s, t, p1-1, p2-1, dp);
            // dont take the equal characters
            int nottake = func(s, t, p1-1, p2, dp);

            return dp[p1][p2] = take+nottake;
        }
        else{
            return dp[p1][p2] = func(s, t, p1-1, p2, dp);
        }
    }
}