class Solution {
    public int minDistance(String word1, String word2) {
        
        /*
            horse  rorse
            ros
        */

        int n = word1.length();
        int m = word2.length();

        if(n==0 && m==0) return 0;
        else if(n==0 && m!=0) return m;
        else if (m==0 && n!=0) return n;

        int [][] dp = new int [n+5][m+5];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++) dp[i][j] = 0;
        }

        // Base Case
        for(int p1=0; p1<dp.length; p1++){
            dp[p1][0] = p1;
        }
        for(int p2=0; p2<dp[0].length; p2++){
            dp[0][p2] = p2;
        }


        for(int p1=1; p1<=n; p1++){
            for(int p2=1; p2<=m; p2++){

                if(word1.charAt(p1-1) == word2.charAt(p2-1)){
                    dp[p1][p2] = dp[p1-1][p2-1]; 
                }
                else{
                    // shift pointer of word in which nothing is inserted (NOT word in which we inserted)
                    int insert = dp[p1][p2-1] + 1; 

                    int replace = dp[p1-1][p2-1] + 1; 

                    int delete = dp[p1-1][p2] + 1; 

                    int ans1 = Math.min(insert, replace);
                    int ans2 = Math.min(ans1, delete);

                    dp[p1][p2] = ans2;
                }

            }
        }

        // int ans = func(word1, word2, n-1, m-1, dp);
        return dp[n][m];
    }

    static int func(String word1, String word2, int p1, int p2, int [][] dp){

        // return the left letters
        if(p1<0) return p2+1;
        if(p2<0) return p1+1;

        if(word1.charAt(p1) == word2.charAt(p2)){
            return dp[p1][p2] = func(word1, word2, p1-1, p2-1, dp);
        }
        else{
            // shift pointer of word in which nothing is inserted (NOT word in which we inserted)
            int insert = func(word1, word2, p1, p2-1, dp) + 1;

            int replace = func(word1, word2, p1-1, p2-1, dp) + 1;

            int delete = func(word1, word2, p1-1, p2, dp) + 1;

            int ans1 = Math.min(insert, replace);
            int ans2 = Math.min(ans1, delete);

            return dp[p1][p2] = ans2;
        }
    }
}