class Solution {
    public String shortestCommonSupersequence(String text1, String text2) {
        
        /*
          a b a c
        c 0 0 0 1
        a 1 1 1 2
        b 1 2 2 3.    abc
        */

        int n = text1.length();
        int m = text2.length();

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

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){

                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = 0 + Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        
        // to get the common part
        String ans = "";
        
        int i=n;
        int j=m;

        while(i>0 && j>0){

            if(text1.charAt(i-1) == text2.charAt(j-1)){
                ans += text1.charAt(i-1);
                i = i-1;
                j = j-1;
            }
            
            else if(dp[i-1][j] > dp[i][j-1]){
                ans += text1.charAt(i-1);
                i = i-1;
            }
            else{
                ans += text2.charAt(j-1);
                j = j-1;
            }
        }

        // add the remaining characters
        while(i>0){
            ans += text1.charAt(i-1);
            i--;
        }

        while(j>0){
            ans += text2.charAt(j-1);
            j--;
        }

        String rev = "";
        for(int k=ans.length()-1; k>=0; k--){
            rev += ans.charAt(k);
        }
                
        return rev;  

    }
}