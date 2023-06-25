class Solution
{
	// Function to find the peak element
	// arr[]: input array
	// n: size of array a[]
	public int peakElement(int[] arr,int n)
    {
       if(n==1) return 0;
       // checking if edge values are peak elements
       if(arr[n-1] >= arr[n-2]) return n-1;
       if(arr[0] >= arr[1]) return 0;
       
       // since edge values are peak elements, search space shrinks
       int low = 1;
       int high = n-2;
       
       while(low <= high){
           int mid = low + (high-low)/2;
           
           // check if element at mid is peak element
           if(arr[mid-1]<=arr[mid] && arr[mid]>=arr[mid+1]) return mid;
           
           // see which half has grater values
           // if left half has greater values
           else if(arr[mid-1] >= arr[mid]){
               high = mid-1;    // move search space to left
           }
           
           // if right half has greater values
           else if(arr[mid] <= arr[mid+1]){
               low = mid+1;    // move search space to right
           }
       }
       
       return -1;
    }
}