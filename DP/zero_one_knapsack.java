class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int [][] dp = new int [1005][1005];
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         for(int i=0; i<dp.length; i++){
             for(int j=0; j<dp[0].length; j++){
                 dp[i][j] = -1;
             }
         }
         
         int ans = knapsack(W, wt, val, n-1, W);
         return ans;
    } 
    
    static int knapsack(int W, int [] wt, int [] val, int index, int wtleft){
        
       if(index < 0) return 0;
       
       if(wtleft == 0) return 0;
       
       if(dp[index][wtleft] != -1) return dp[index][wtleft];
       
        // dont pick
        int ans = knapsack(W, wt, val, index-1, wtleft);
        
        // pick
        if((wtleft - wt[index])>=0){
            ans = Math.max(ans, knapsack(W, wt, val, index-1, wtleft - wt[index]) + val[index]); 
        }
        
        return dp[index][wtleft] = ans;
        
    }
}