class Solution
{
    public int[][] overlappedInterval(int[][] Intervals)
    {
        int n = Intervals.length;
        sort(Intervals, 0);
        Stack<pair> st = new Stack<>();
        
        for(int i=0; i<n; i++){
            int curr_start = Intervals[i][0];
            int curr_end = Intervals[i][1];
            
            if(st.isEmpty()){
                st.add(new pair(curr_start, curr_end));
            }
            else{
                pair prev = st.peek();
                int prev_start = prev.x;
                int prev_end = prev.y;
                
                // if overlapping
                if(curr_start <= prev_end){
                    st.pop();
                    int merged_start = Math.min(curr_start, prev_start);
                    int merged_end = Math.max(curr_end, prev_end);
                    st.add(new pair(merged_start, merged_end));
                }
                
                // if no overlapping, add in stack
                else st.add(new pair(curr_start, curr_end));
            }
        }
        
        
        int size = st.size();
        int [][] ans = new int [size][2];
        int i = size-1;
        
        while(!st.isEmpty() && i>=0){
            pair curr = st.peek();
            int start = curr.x;
            int end = curr.y;
            
            ans[i][0] = start;
            ans[i][1] = end;
            i--;
            st.pop();
        }
        
        return ans;
        
    }
    
    static void sort(int [][] arr, int col){
        Arrays.sort(arr, (a, b) -> Integer.compare(a[col],b[col]) );
    }
}

class pair{
    int x, y;
    pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}