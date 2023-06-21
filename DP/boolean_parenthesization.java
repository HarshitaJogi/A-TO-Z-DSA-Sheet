class Solution{
    static int countWays(int N, String S){
        int M = 1003;
        
        int [][][] dp = new int [N+5][N+5][3];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                for(int k=0; k<dp[0][0].length; k++) dp[i][j][k] = -1;
            }
        }
        
        // we pass 1 for isTrue bec we want the result to be true
        int ans = func(0, N-1, 1, S, dp);
        return ans%M;
    }
    
    // return the number of ways we can obtain 'isTrue' from string of part i to j
    static int func(int i, int j, int isTrue, String S, int [][][] dp){
        
        int M = 1003;
        
        if(i>j) return 0;
        
        if(i==j){
            if(isTrue == 1){
                if(S.charAt(i) == 'T') return 1;
                else return 0;
            }
            else{
                if(S.charAt(i) == 'F') return 1;
                else return 0;
            }
        }
        
        if(dp[i][j][isTrue] != -1) return dp[i][j][isTrue];
        
        
        int ways = 0;
        
        // start from i+1 bec first operation is at index i+1
        // ind+2 bec the operation is at every 2 indices.
        for(int ind=i+1; ind<j; ind=ind+2){
            // for left half of String
            int leftTrue = func(i, ind-1, 1, S, dp);  
            int leftFalse = func(i, ind-1, 0, S, dp);  
            // for right half of string
            int rightTrue = func(ind+1, j, 1, S, dp);
            int rightFalse = func(ind+1, j, 0, S, dp);
            
            
        
            // finding number of ways
            if(S.charAt(ind) == '|'){
                // for true
                int bothTrue = leftTrue * rightTrue;
                int eitherTrue = leftTrue*rightFalse + leftFalse*rightTrue;
                
                // for false
                int bothFalse = leftFalse * rightFalse;
                
                if(isTrue == 1){
                    ways = (ways%M + bothTrue%M + eitherTrue%M)%M; // bec OR is true when both are true or one is true
                }
                else{
                    ways = (ways%M + bothFalse%M)%M;    // bec OR is false only when both are false
                }
            }
            
            
            if(S.charAt(ind) == '&'){
                // for true
                int bothTrue = leftTrue * rightTrue;
                
                // for false
                int bothFalse = leftFalse * rightFalse;
                int eitherFalse = leftTrue*rightFalse + leftFalse*rightTrue;
                
                if(isTrue == 1){
                    ways = (ways%M + bothTrue%M)%M;  // bec AND is true only when both are true
                }
                else{
                    ways = (ways%M + bothFalse%M + eitherFalse%M)%M;    // bec AND is false when both are false or one is f
                }
            }
            
            
            if(S.charAt(ind) == '^'){
                // for true
                int eitherTrue = leftTrue*rightFalse + leftFalse*rightTrue;
                
                // for false
                int bothTrue = leftTrue * rightTrue;
                int bothFalse = leftFalse * rightFalse;
                
                
                if(isTrue == 1){
                    ways = (ways%M + eitherTrue%M)%M;  // bec XOR is true only when either are true
                }
                else{
                    ways = (ways%M + bothTrue%M + bothFalse%M)%M;    // bec XOR is false when either is t/f
                }
            }
            
        }
        
        
        
        
        
        return dp[i][j][isTrue] = ways%M;
        
    }
}