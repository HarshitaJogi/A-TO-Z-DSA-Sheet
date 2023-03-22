//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;


// } Driver Code Ends
//User function Template for Java

class Solution{
    
    //Function to return sum of count of set bits in the integers from 1 to n.
    public static int countSetBits(int n){
    
        
       int cnt = 0;
       int A = n/2;
       cnt += A;
       
       int power = 1;
       while((1<<power)<n){
           int groups = n/(1<<power);
           int tot_set = groups*(1<<power);
           if(tot_set%2!=0){
               cnt += (n%(1<<power));
           }
           power++;
       }
       
       
    //   int power = 1;
    //   while((1<<power)<=n){
    //       int x = n/(power);
    //       x = x/2;
    //       x = x*(1<<power);
    //       cnt += x;
    //       if(x%2==0){
    //           cnt += (n%(1<<power));
    //       }
    //       power++;
    //   }
       
       return cnt;
       
       
        // int cnt = 0;
        // for(int i=1; i<=n; i++){
        //     for(int j=0; j<31; j++){
        //         if(((i>>j)&1)== 1) cnt++;
        //     }
        
        // }
        
        // return cnt;
        
    }
}

//{ Driver Code Starts.

// Driver code
class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();//testcases
		int x, n;
		while(t-->0) {
	        n = sc.nextInt();//input n

		    Solution obj = new Solution();

		    System.out.println(obj.countSetBits(n));//calling countSetBits() method
		}
	}
}

// } Driver Code Ends