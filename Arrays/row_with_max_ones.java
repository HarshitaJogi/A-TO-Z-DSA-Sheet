
//User function Template for Java

class Solution {
    int rowWithMax1s(int arr[][], int n, int m) {
        
        int ans = Integer.MAX_VALUE;
        int row_no = -1;
        int target = 1;
        
        for(int i=0; i<n; i++){
            int current = first_occ(arr[i], m, target);
            //System.out.println("Current is: " + current);
            if(current < ans && current<m){
                ans = current;
                row_no = i;
            }
        }
        //System.out.println(first_occ(arr[0], m, 1));
        
        return row_no;
        
    }
    
    static int first_occ(int row[], int m, int target){
        
        int low = 0;
        int high = m-1;
        
        while(low<=high){
            int mid = low + (high - low)/2;
            
            //if(row[mid] == target) return mid;
            
            if(row[mid] >= target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        
        return low;
    }
}