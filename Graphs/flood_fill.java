class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int m = image.length;
        int n = image[0].length;

        boolean [][] vis = new boolean [m][n];
        
        bfs(image, vis, sr, sc, color);

        return image;
    }

    static void bfs (int [][] image, boolean [][] vis, int sr, int sc, int color){

        int m = image.length;
        int n = image[0].length;
        
        int initial_col = image[sr][sc];
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(new Pair(sr, sc));
        vis[sr][sc] = true;
        image[sr][sc] = color;

        while(!q.isEmpty()){
            Pair<Integer, Integer> curr = q.poll();
            int curr_x = curr.getKey();
            int curr_y = curr.getValue();

            int [] x_coord = {0, 0, 1, -1};
            int [] y_coord = {1, -1, 0, 0};

            for(int i=0; i<4; i++){
                int child_x = curr_x + x_coord[i];
                int child_y = curr_y + y_coord[i];

                if(child_x>= m || child_x<0 || child_y>=n || child_y<0) continue;
                if(vis[child_x][child_y] == true) continue;

                if(image[child_x][child_y] == initial_col){
                    vis[child_x][child_y] = true;
                    image[child_x][child_y] = color;
                    q.add(new Pair(child_x, child_y));
                }
                
            }
        }
    }
}