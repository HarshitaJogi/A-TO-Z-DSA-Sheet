class Solution {
    
   
    public int minimumEffortPath(int[][] heights) {
        int [][] dist = new int [heights.length][heights[0].length];
        int INF = (int)1E9;
        for(int i=0; i<dist.length; i++){
            for(int j=0; j<dist[0].length; j++){
                dist[i][j] = INF;
            }
        }

        int ans = dijkstra(heights, dist);

        for(int i=0; i<dist.length; i++){
            for(int j=0; j<dist[0].length; j++){
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
        
        
        if(ans == INF) return -1;
        else return ans;
    }

    static int dijkstra(int [][]heights, int [][] dist){

        int ans = (int)1E9;
        
        int n = heights.length;
        int m = heights[0].length;

        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>((x,y) -> x.distance - y.distance);

        dist[0][0] = 0;
        pq.add(new Tuple(0, 0, 0));

        // defining the children
        int [] child_x_coord = {0, 0, 1, -1};
        int [] child_y_coord = {1, -1, 0, 0};

        while(pq.size() != 0){
            Tuple curr = pq.peek();
            int curr_diff = curr.distance;
            int curr_row = curr.row;
            int curr_col = curr.col;
            pq.remove();

            if(curr_row == n-1 && curr_col == m-1) ans = Math.min(ans, curr_diff);

            for(int i=0; i<4; i++){
                int child_row = curr_row + child_x_coord[i];
                int child_col = curr_col + child_y_coord[i];

                if(child_row <0 || child_row>=n || child_col<0 || child_col>=m) continue;

             int child_diff = Math.max(curr_diff, Math.abs(heights[child_row][child_col] - heights[curr_row][curr_col]));

                if(child_diff < dist[child_row][child_col]){
                    dist[child_row][child_col] = child_diff;
                    pq.add(new Tuple(child_diff, child_row, child_col));
                }
            }
        }

        return ans;
    }
}

public class Tuple{
    int distance;
    int row;
    int col;

    public Tuple(int distance, int row, int col){
        this.distance = distance;
        this.row = row;
        this.col = col;
    }
}