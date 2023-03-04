
//User function Template for Java

class Solution {
    int print2largest(int arr[], int n) {
        
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            max = Math.max(max, arr[i]);
        }
        
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            if(max != arr[i]){
                ans = Math.max(ans, arr[i]);
            }
        }
        
        if(ans == Integer.MIN_VALUE) return -1;
        else return ans;
    }
}