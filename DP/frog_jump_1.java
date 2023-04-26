class Solution{
    static int [] dp = new int [100000];
    public int minimumEnergy(int arr[],int N){
        
        Arrays.fill(dp, -1);
        int ans = func(arr, N-1);
        return ans;
    }
    
    static int func( int [] arr, int index){
        
        int energy = Integer.MAX_VALUE;
        
        if(index == 0) return 0;
        if(dp[index] != -1) return dp[index];
        
        // way 1
        energy = Math.min(energy, func(arr, index-1) + Math.abs(arr[index] - arr[index-1]));
        
        // way 2
        if(index > 1){
            energy = Math.min(energy, func(arr, index-2) + Math.abs(arr[index] - arr[index-2]));
        }
        
        
        return dp[index] = energy;
    }
}