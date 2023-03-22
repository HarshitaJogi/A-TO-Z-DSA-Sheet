//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            Solution obj = new Solution();
            obj.sieve();
            List<Integer> ans = obj.findPrimeFactors(n);
            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // You must implement this function
    static void sieve() {}

    static List<Integer> findPrimeFactors(int N) {
        // code here
        int [] sieve = new int [N+10];
        List<Integer> primes = new ArrayList<Integer>();
        
        for(int i=2; i<=N; i++){
            if(sieve[i]==0){
                for(int j=i; j<=N; j+=i){
                    sieve[j] = i;
                    if(j==N){
                        primes.add(i);
                    }
                }
            }
        }
        
        List<Integer> ans = new ArrayList<Integer>();
        for(int i=0; i<primes.size(); i++){
            int curr = primes.get(i);
            while(N%curr==0){
                ans.add(curr);
                N = N/curr;
            }
        }
        
        return ans;
        
    }
}
