class Solution
{
    public void shortest_distance(int[][] matrix)
    {
        int n = matrix.length;
        int INF = (int)1E9;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == -1) matrix[i][j] = INF;
            }
        }
        
        for(int via=0; via<n; via++){
            
            for(int i=0; i<n; i++){
                
                for(int j=0; j<n; j++){
                    matrix[i][j] = Math.min(matrix[i][j], (matrix[i][via] + matrix[via][j]));
                }
            }
        }
        
         for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == INF) matrix[i][j] = -1;
            }
        }
        
    }
}