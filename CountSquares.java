class CountSquares {
    //https://leetcode.com/problems/count-square-submatrices-with-all-ones/submissions/
    public int countSquares(int[][] matrix) {
        
        int ans = 0;
        int noOfRows = matrix.length;
        int noOfCols = matrix[0].length;
        int maxSize = noOfRows;
        if(maxSize < noOfCols){
            maxSize = noOfCols;
        }
        for(int i=0;i<noOfRows; i++){
            for(int j=0;j<noOfCols;j++){
                for(int k=1;k<=maxSize;k++){
                    if(doesSquareContainAllOnes(matrix, i, j, k)){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
    
    private boolean doesSquareContainAllOnes(int[][]matrix, int startX, int startY, int size){
        int squareStartX = startX;
        int squareEndX = startX+size-1;
        int squareStartY = startY;
        int squareEndY = startY + size - 1;
        if(squareEndX >= matrix.length || squareEndY>=matrix[0].length){
            return false;
        }
        
        for(int i=squareStartX;i<=squareEndX;i++){
            for(int j=squareStartY;j<=squareEndY;j++){
                if(matrix[i][j] != 1){
                    return false;
                }
            }
        }
        return true;
    }
    
}
