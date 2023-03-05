
class Solution{
    //Function to find the leaders in the array.
    static ArrayList<Integer> leaders(int arr[], int n){
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
       int x = Integer.MIN_VALUE;
       //ans.add(x);
       for(int i=n-1; i>=0; i--){
           if(arr[i]>=x){
               ans.add(arr[i]);
               x = arr[i];
           }
       }
      
        Collections.reverse(ans);
        
        return ans;
    }
}