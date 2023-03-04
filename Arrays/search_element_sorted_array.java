class Solution{
    static int searchInSorted(int arr[], int N, int K)
    {
        
        int low = 0;
        int high = N-1;
        int ans = -1;
        
        while(low<=high){
            int mid = low + (high-low)/2;
            
            if(arr[mid] == K){
                ans = 1;
                break;
            }
            
            if(arr[mid]>K){
                high = mid-1;
            }
            
            if(arr[mid]<K){
                low = mid+1;
            }
        }
        
        return ans;
        
    }
}