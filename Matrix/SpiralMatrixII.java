class SpiralMatrixII {
    //https://leetcode.com/problems/spiral-matrix-ii/submissions/
    int n;
    int value = 1;
    public int[][] generateMatrix(int n) {
        this.n = n;
        int[][] matrix = new int[n][n];
        
        matrix[0][0] = value;
        
        int rowStart = 0;
        int colStart = 0;
        int rowEnd = this.n-1;
        int colEnd = this.n-1;
        
        while(rowStart<=rowEnd && colStart<=colEnd){
            for(int i=colStart;i<=colEnd; i++){
                matrix[rowStart][i] = this.value;
                this.value++;
            }
            rowStart ++;
            
            for(int i=rowStart; i<=rowEnd;i++){
                matrix[i][colEnd] = this.value;
                this.value++;
            }
            colEnd--;
            
            if(rowStart<=rowEnd){
                for(int i=colEnd;i>=colStart;i--){
                    matrix[rowEnd][i] = this.value;
                    this.value++;
                }
                
            }
            rowEnd--;
            
            if(colStart<=colEnd){
                for(int i=rowEnd;i>=rowStart;i--){
                    matrix[i][colStart] = this.value;
                    this.value++;
                }
                
            }
            colStart++;    
        }
        
        return matrix;
    }
}
