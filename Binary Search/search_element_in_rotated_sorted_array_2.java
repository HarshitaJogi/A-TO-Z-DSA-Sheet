class Solution {
    public static boolean Search(int N, int[] arr, int target) {
        
        int low = 0;
        int high = N-1;
        
        while(low<=high){
            int mid = low + (high-low)/2;
            
            if(arr[mid] == target) return true;
            
            // if we find duplicates at both ends, shrink the search space
            if(arr[low] == arr[mid] && arr[mid] == arr[high]){
                low = low+1;
                high = high-1;
                continue;  // bec if same condition happens even after shrinking, reduce further
            }
            
            // check if left half is sorted
            if(arr[low]<=arr[mid]){
                // check if target lies in left half
                if(arr[low]<=target && target<=arr[mid]){
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
            
            // right half is sorted
            else{
                // check if target lies in right half
                if(arr[mid]<=target && target<=arr[high]){
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }
        }
        
        return false;
    }
}