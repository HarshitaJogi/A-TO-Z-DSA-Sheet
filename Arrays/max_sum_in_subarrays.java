class Solution {
    
    public static long pairWithMaxSum(long arr[], long N)
    {
        long sum = 0;
        long max = Integer.MIN_VALUE;
        
        for(long i=0; i<N-1; i++){
            sum = arr[(int)i] + arr[(int)i+1];
            max = Math.max(max, sum);
        }
        
        return max;
    }
}