class Solution {
    static boolean [][] vis = new boolean [1000][1000];
    static int m,n;
    public void setZeroes(int[][] matrix) {
        
       int row = matrix.length;
       int col = matrix[0].length;

        boolean firstrowZero = false;

        // determine which rows/cols need to be zero
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(matrix[i][j]==0){
                    matrix[0][j] = 0;
                    if(i>0){
                        matrix[i][0] = 0;
                    }
                    else if(i==0){
                        //System.out.println("hello");
                        firstrowZero = true;
                    }
                }
            }
        }

        // iterate through the matrix again
        for(int i=1; i<row; i++){
            for(int j=1; j<col; j++){
                if(matrix[0][j]==0 || matrix[i][0]==0){
                    matrix[i][j]=0;
                }
            }
        }

        // for first column
        if(matrix[0][0]==0){
            for(int i=0; i<row; i++){
                matrix[i][0] = 0;
            }
        }

        // for first row
        if(firstrowZero == true){
            for(int i=0; i<col; i++){
                matrix[0][i] = 0;
            }
        }



        // FIRST OPTIMIZATION
        // int [] r = new int [row];
        // int [] c = new int [col];
        // Arrays.fill(r, 1);
        // Arrays.fill(c, 1);

        // for(int i=0; i<row; i++){
        //     for(int j=0; j<col; j++){
        //         if(matrix[i][j]==0){
        //             r[i]=0;
        //             c[j]=0;
        //         }
        //     }
        // }

        // for(int i=0; i<row; i++){
        //     for(int j=0; j<col; j++){
        //         if(r[i]==0 || c[j]==0){
        //             matrix[i][j]=0;
        //         }
        //     }
        // }
       
        
   // BRUTE FORCE
    //     for(int a=0; a<row; a++){
    //         for(int b=0; b<col; b++){
    //             zero_matrix[a][b] = 1;
    //         }
    //     }
        
    //     for(int i=0; i<row; i++){
    //         for(int j=0; j<col; j++){
    //             if(matrix[i][j] == 0){
    //                 zero_matrix[i][j] = 0;
    //             }
    //         }
    //     }
        
    //    for(int p=0; p<row; p++){
    //        for(int q=0; q<col; q++){
    //            System.out.print(zero_matrix[p][q]);
    //        }
    //        System.out.println();
    //    }
       
    //    for(int i=0; i<row; i++){
    //        for(int j=0; j<col; j++){
               
    //            // To make column zero:
    //            for(int k=0; k<col; k++){
    //                if(zero_matrix[i][j] == 0){
    //                    matrix[i][k] = 0;
    //                }
    //            }
               
    //            // To make row zero
    //            for(int k=0; k<row; k++){
    //                if(zero_matrix[i][j] == 0){
    //                    matrix[k][j] = 0;
    //                }
    //            }
    //        }
    //    }
       
       for(int i=0; i<row; i++){
           for(int j=0;j<col;j++){
               System.out.print(matrix[i][j]);
           }
           System.out.println();
       }
    } 

    
}