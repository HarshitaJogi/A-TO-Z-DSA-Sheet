class Solution {
    public int countPrimes(int n) {
        int cnt = 0;
        int [] sieve = new int [n+10];
        Arrays.fill(sieve, 0);

        for(int i=2; i<=n; i++){
            if(sieve[i]==0){
                for(int j=2*i; j<=n; j+=i){
                    sieve[j] = 1;
                }
            }

        }

        for(int i=2; i<n; i++){
            if(sieve[i]==0) cnt++;
        }

        return cnt;
    }
}