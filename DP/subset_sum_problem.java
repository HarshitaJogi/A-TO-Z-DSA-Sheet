class Solution{
    static boolean [][] dp = new boolean [205][100005];
    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j] = false;
            }
        }
        
        
        // TABULAR METHOD
        
        // base cases
        for(int index=0; index<N; index++) dp[index][0] = true;
        dp[0][arr[0]] = true;
        
        for(int index = 1; index<N; index++){
            for(int target=1; target<=sum; target++){
                
                boolean nottake = dp[index-1][target];
        
                boolean take = false;
                if(target >= arr[index]){
                    take = dp[index-1][target-arr[index]];
                }
                
                dp[index][target] = take | nottake;
                
            }
        }
        
        return dp[N-1][sum];
    }
    
    
    // static boolean func(int [] arr, int sum, int index){
        
    //     if(sum == 0) return true;
        
    //     if(index == 0){
    //         if(sum == arr[index]) return true;
    //         else return false;
    //     }
        
    //     if(dp[index][sum] != -1){
    //         if(dp[index][sum] == 1) return true;
    //         else return false;
    //     }
        
    //     boolean nottake = func(arr, sum, index-1);
        
    //     boolean take = false;
    //     if(sum >= arr[index]){
    //         take = func(arr, sum-arr[index], index-1);
    //     }
        
    //     boolean ans = nottake | take;
    //     if(ans == true) dp[index][sum] = 1;
    //     else dp[index][sum] = 0;
        
    //     return nottake | take;
    // }
    