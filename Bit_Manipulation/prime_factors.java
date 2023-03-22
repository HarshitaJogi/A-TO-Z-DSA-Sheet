
class Solution
{
   
    public int[] AllPrimeFactors(int N)
    {
        List<Integer> l = new ArrayList<Integer>();
        int [] sieve = new int [N+10];
        Arrays.fill(sieve, 0);
        
        for(int i=2; i<=N; i++){
            if(sieve[i]==0){
                for(int j=i; j<=N; j+=i){
                    sieve[j] = i;
                    if(j==N){
                        l.add(i);
                    }
                }
            }
        }
        
        int n = l.size();
        int [] ans = new int [n];
        for(int i=0; i<n; i++){
            ans[i] = l.get(i);
        }
        
        return ans;
    }
}