class MatrixReshape {
    //https://leetcode.com/problems/reshape-the-matrix/submissions/
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int rows = mat.length;
        int cols = mat[0].length;
        if(rows*cols != r*c){
            return mat;
        }
        int[][] ans = new int[r][c];
        
        int i=0;
        for(i=0;i<r*c;i++){
            ans[i/c][i%c] = mat[i/cols][i%cols];
        }
        
        return ans;
    }
}
