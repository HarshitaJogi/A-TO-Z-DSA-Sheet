class Solution
{
  static void insert(int arr[],int i)
  {
    //   for(int x=i; x>=0; x--){
    //       if(arr[i]>arr[x]){
    //           int temp = arr[i];
    //           arr[i] = arr[x];
    //           arr[x] = temp;
    //       }
    //   }
  }
  //Function to sort the array using insertion sort algorithm.
  public void insertionSort(int arr[], int n)
  {
    //   if(arr[0]>arr[1]){
    //       int temp = arr[0];
    //       arr[0] = arr[1];
    //       arr[1] = temp;
    //   }
      
    //   for(int i=1; i<n-1; i++){
    //       if(arr[i] > arr[i+1]){
    //           insert(arr, i);
    //       }
    //   }
    
    for(int i=0; i<n; i++){
        int j=i;
        while(j>0 && arr[j]<arr[j-1]){
            int temp = arr[j];
            arr[j] = arr[j-1];
            arr[j-1] = temp;
            j--;
        }
    }
  }
}