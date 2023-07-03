class GfG
{
    int maxLen(int arr[], int n)
    {
        int maxi = 0;
        int sum = 0;
        // hashmap stores prefixsum and index
        HashMap<Integer, Integer> m = new HashMap<>();
        
        for(int i=0; i<n; i++){
            sum += arr[i];
            
            // if we find an index till which sum is zero
            if(sum == 0){
                maxi = i - 0 + 1;   // length will be first index to current index
            }
            
            else{
                if(m.containsKey(sum)){
                    int lastIndexAtWhichSumOccured = m.get(sum);
                    maxi = Math.max(maxi, (i - lastIndexAtWhichSumOccured));
                }
                else{
                    m.put(sum, i);
                }
            }
        }
        
        return maxi;
    }
}