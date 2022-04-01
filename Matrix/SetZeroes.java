class SetZeroes {
    //https://leetcode.com/problems/set-matrix-zeroes/submissions/
    public void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        
        int rL = matrix.length;
        int cL = matrix[0].length;
        
        for(int i=0;i<rL;i++)
        {
            for(int j=0;j<cL;j++){
                if(matrix[i][j] == 0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }   
        
        Iterator itr = rows.iterator();
        
        while(itr.hasNext()){
            int r = (int)itr.next();
            for(int i=0;i<cL;i++){
                matrix[r][i] = 0;
            }
        }
        
        itr = cols.iterator();
        
        while(itr.hasNext()){
            int c = (int)itr.next();
            for(int i=0;i<rL;i++){
                matrix[i][c] = 0;
            }
        }
    }
        
}
