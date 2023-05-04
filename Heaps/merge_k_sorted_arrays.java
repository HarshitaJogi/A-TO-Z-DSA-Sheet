class Solution
{
    //Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) 
    {
        // Write your code here.
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                pq.add(arr[i][j]);
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        // Iterator itr = pq.iterator();
        // while(itr.hasNext()){
        //     int x = itr.next();
        //     ans.add(x);
        // }
        
        // System.out.println(pq.size());
        
        // for(int i=0; i<pq.size(); i++){
        //     int x = pq.poll();
        //     ans.add(x);
        // }
        
        while(!pq.isEmpty()){
            int x = pq.peek();
            ans.add(x);
            pq.poll();
            
        }
        
        return ans;
        
    }
}