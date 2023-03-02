
class Solution
{
	int  select(int arr[], int i)
	{
        // code here such that selectionSort() sorts arr[]
        int mini = i;
        for(int j=i+1; j<arr.length; j++){
            if(arr[j]<arr[mini]) mini = j;
        }
        
        return mini;
        
        
	}
	
	void selectionSort(int arr[], int n)
	{
	    for(int i=0; i<n; i++){
	        int min = select(arr, i);
	        int temp = 0;
            temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
	        
	    }
	    
	}
}
