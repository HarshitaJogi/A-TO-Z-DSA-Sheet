
class Solution {
    int count(int[] arr, int n, int x) {
        int low = 0;
        int high = n-1;
        int first=-1;


        // for floor
        while(low<=high){
            int mid = low + (high-low)/2;

            if(arr[mid] == x){
                first = mid;
                high = mid-1;
            } 

            else if(arr[mid]>x){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }

        // for ceil
        low = 0;
        high = n-1;
        int last = -1;
        while(low<=high){
            int mid = low + (high-low)/2;

            if(arr[mid] == x){
                last = mid;
                low = mid+1;
            }

            else if(arr[mid]<x){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }

        int ans = last - first + 1;
        
        if(first==-1 && last==-1) ans = 0;
        
        return ans;
    }
}