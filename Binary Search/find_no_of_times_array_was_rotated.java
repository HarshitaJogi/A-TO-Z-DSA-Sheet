class Solution {
    int findKRotation(int arr[], int n) {
        
        int low = 0;
        int high = n-1;
        int min_element = Integer.MAX_VALUE;
        int min_index = -1;
        
        while(low<=high){
            int mid = low + (high-low)/2;
            
            // if left half sorted
            if(arr[low]<=arr[mid]){
                if(arr[low] < min_element){
                    min_element = arr[low];
                    min_index = low;
                }
                low = mid+1;
            }
            
            // right half is sorted
            else{
                if(arr[mid] < min_element){
                    min_element = arr[mid];
                    min_index = mid;
                }
                high = mid-1;
            }
        }
        
        return min_index;
    }
}