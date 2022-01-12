class RotateMatrix {
    //https://leetcode.com/problems/rotate-image/submissions/
    public void rotate(int[][] matrix) {
        int n = matrix[0].length;
   
        for(int l =0;l<n/2;l++){
            for(int i = l;i<n-l-1;i++){
                int temp = matrix[l][i];
                matrix[l][i] = matrix[n-i-1][l];
                matrix[n-i-1][l] = matrix[n-l-1][n-i-1];
                matrix[n-l-1][n-i-1] = matrix[i][n-l-1];
                matrix[i][n-l-1] = temp;
            }
        }
    }
}
