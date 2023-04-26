class Solution{
    static int [][] dp = new int [100005][5];
    public int maximumPoints(int points[][],int N){
        //code here
        
        for(int i=0; i<points.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        int ans = func(points, N-1, N, -1);
        return ans;
    }
    
    static int func(int [][] points, int index, int N, int prev){
        
        if(index < 0) return 0;
        if(prev!=-1 && dp[index][prev] != -1) return dp[index][prev];
        
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<3; i++){
            if(i == prev) continue;
            ans = Math.max(ans, func(points, index-1, N, i) + points[index][i]);
        }
        
        if(prev == -1) return ans;
        else return dp[index][prev] = ans;
        
    }