class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        
        ArrayList<int []> list = new ArrayList<int []>();

        sort(intervals);

        // Arrays.sort(intervals);

        // for(int i=0; i<n-1; i++){
        //     int [] curr = intervals[i];
        //     int [] next = intervals[i+1];
        //     int [] add = new int [2];

        //     int curr_start = curr[0];
        //     int curr_end = curr[1];
        //     int next_start = next[0];
        //     int next_end = next[1];

        //     if(next_start<=curr_end){
        //         add[0] = curr_start;
        //         add[1] = Math.max(curr_end, next_end);
        //     }
        //     else{
        //         add[0] = curr_start;
        //         add[1] = curr_end;
        //     }

        //     ans[i] = add;
        // }

        for(int i=0; i<n; i++){
            int [] curr = intervals[i];
            if(list.isEmpty()){
                list.add(curr);
            }
            else{
                int curr_start = curr[0];
                int curr_end = curr[1];
                int last_start = list.get(list.size()-1)[0];
                int last_end = list.get(list.size()-1)[1];

                if(curr_start>=last_start && curr_start<=last_end){
                    list.remove(list.size()-1);
                    int [] add = {Math.min(last_start, curr_start), Math.max(last_end, curr_end)};
                    list.add(add);
                }
                else{
                    // System.out.println("hi");
                    list.add(curr);
                }
            }
        }
        int [][] ans = new int [list.size()][2];

        for(int i=0; i<list.size(); i++){
            int [] curr = list.get(i);
            ans[i] = curr;
        }

        return ans;
    }

    static void sort(int [][] intervals){
        int row = intervals.length;
        int col = 2;
        for(int i=0; i<row; i++){
            for(int j=i+1; j<row; j++){
                if(intervals[i][0]>intervals[j][0]){
                    int temp = intervals[i][0];
                    intervals[i][0] = intervals[j][0];
                    intervals[j][0] = temp;

                    int temp1 = intervals[i][1];
                    intervals[i][1] = intervals[j][1];
                    intervals[j][1] = temp1;

                }
            }
        }
        return;
    }
}