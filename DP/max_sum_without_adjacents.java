
class Solution {
    static int [] dp = new int [(int)1E7];
    int findMaxSum(int arr[], int n) {
        // code here
        Arrays.fill(dp, -1);
        int ans = func(arr, n-1);
        return ans;
    }
    
    static int func(int [] arr, int index){
        
        if(index < 0) return 0;
        if(dp[index] != -1) return dp[index];
        
        // do not pick
        int sum = func(arr, index-1); 
        
        // pick
         sum = Math.max(sum, func(arr, index-2) + arr[index]);
       
        return dp[index] = sum;
        
    }
}