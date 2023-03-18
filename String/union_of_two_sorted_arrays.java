//User function Template for Java

//arr1,arr2 : the arrays
// n, m: size of arrays
class Solution
{
    //Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        int p1 = 0;
        int p2 = 0;
        
        // int min = Math.min(arr1[0], arr2[0]);
        // ans.add(min);
        
        //int min_len = Math.min(n, m);
        
        if(arr1[p1]==arr2[p2]){
            ans.add(arr1[p1]);
            p1++;
            p2++;
        } 
        else{
            if(arr1[p1]<arr2[p2]){
                ans.add(arr1[p1]);
                p1++;
            } 
            else{
                ans.add(arr2[p2]);
                p2++;
            } 
        }
        
        while(p1<n && p2<m){
            
            if(arr1[p1]<arr2[p2]){
                if(arr1[p1] != ans.get(ans.size()-1)){
                    ans.add(arr1[p1]);
                }
                p1++;
            }
            else if(arr2[p2]<arr1[p1]){
                if(arr2[p2] != ans.get(ans.size()-1)){
                    ans.add(arr2[p2]);
                }
                p2++;
            }
            else{
                if(arr1[p1] != ans.get(ans.size()-1)){
                    ans.add(arr1[p1]);
                }
                p1++;
                p2++;
            }
        }
        
        // if(p1!=n-1){
        //     for(int i=p1+1; i<n; i++){
        //         if(arr1[i]!=ans.get(i-1)){
        //             ans.add(arr1[i]);
        //         }
        //     }
        // }
        
        // if(p2!=m-1){
        //     for(int i=p2+1; i<m; i++){
        //         if(arr2[i]!=ans.get(i-1)){
        //             ans.add(arr2[i]);
        //         }
        //     }
        // }
        
        while(p1<n){
            if(arr1[p1]!=ans.get(ans.size()-1)){
                    ans.add(arr1[p1]);
            }
            p1++;
        }
         while(p2<m){
            if(arr2[p2]!=ans.get(ans.size()-1)){
                    ans.add(arr2[p2]);
            }
            p2++;
        }
        
        return ans;
        
        
    }
}