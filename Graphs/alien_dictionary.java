class Solution
{
    public String findOrder(String [] dict, int N, int K)
    {
        // first construct the directed graph then find the topo sort
        
        int size = K;
        ArrayList<Integer> [] g = new ArrayList[size];
        for(int i=0; i<K; i++){
            g[i] = new ArrayList<Integer>();
        }
        
        
        // making the directed graph
        for(int i=0; i<N-1; i++){
            String s1 = dict[i];
            String s2 = dict[i+1];
            
            // comapre both strings to find the smaller letter
            int pointer = 0;
            while(pointer < s1.length() && pointer < s2.length()){
                if(s1.charAt(pointer) != s2.charAt(pointer)){
                    int par = s1.charAt(pointer) - 'a';
                    int child = s2.charAt(pointer) - 'a';
                    g[par].add(child);
                    // System.out.println(par + ":" + child);
                    break;
                }
                else{
                    pointer++;
                }
            }
        }
        
        // Implement khan's topo algo
        
        int [] indegree = new int [K];
        for(int i=0; i<K; i++){
            for(int child: g[i]){
                indegree[child] += 1;
            }
        }
        
        Queue <Integer> q = new LinkedList<>();
        for(int i=0; i<K; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        
        String ans = "";
        
        while(!q.isEmpty()){
            int curr = q.poll();
            // System.out.print(curr + " ");
            // adding current to ans
            char a = 'a';
            a += curr;
            // System.out.print(a + " ");
            ans += a;
            
            for(int child: g[curr]){
                indegree[child] -= 1;
                if(indegree[child] == 0){
                    q.add(child);
                }
            }
        }
        
        
        // System.out.println(ans);
        
        // char a = 'b';
        // a += 1;
        // System.out.println(a);
        
        return ans;
        
        
    }
}