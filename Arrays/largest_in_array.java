//User function Template for Java

class Compute {
    
    public int largest(int arr[], int n)
    {
        Arrays.sort(arr);
        return arr[n-1];
    }
}
