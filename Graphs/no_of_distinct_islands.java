class Solution {

    int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        boolean [][] vis = new boolean [n+5][m+5];
        
        // stores the structures of all different islands
        // bec pair didnt work, we use arrayList<String>
        HashSet<ArrayList<String>> total = new HashSet<>();
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(vis[i][j] == false && grid[i][j] == 1){
                     ArrayList<String> struc = new ArrayList<>();
                    // bec base row & base col is same as itself when dfs is called
                    dfs(i, j, i, j, grid, vis, struc);
                    total.add(struc);
                }
               
            }
        }
        
        int ans = total.size();
        return ans;
    }
    
static void dfs(int row, int col, int base_row, int base_col, int [][] grid, boolean [][] vis, ArrayList<String> struc){
        int n = grid.length;
        int m = grid[0].length;
        
        vis[row][col] = true;
        // subtract from base row, base col and add in arrayList
        struc.add(Integer.toString(row-base_row));
        struc.add(Integer.toString(col-base_col));
        
        int [] xd = {1, -1, 0, 0};
        int [] yd = {0, 0, 1, -1};
        
        for(int i=0; i<4; i++){
            int child_row = row + xd[i];
            int child_col = col + yd[i];
            
            if(child_row>=n || child_row<0 || child_col>=m || child_col<0) continue;
            if(vis[child_row][child_col] == true) continue;
            if(grid[child_row][child_col] != 1) continue;
            
            dfs(child_row, child_col, base_row, base_col, grid, vis, struc);
        }
    }
}