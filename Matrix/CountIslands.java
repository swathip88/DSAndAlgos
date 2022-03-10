class CountIslands {
    //https://leetcode.com/problems/number-of-islands/submissions/
    public int numIslands(char[][] grid) {
        int noOfRows = grid.length;
        int noOfCols = grid[0].length;
        int count = 0;  
        for(int i=0;i<noOfRows;i++){
            for(int j=0;j<noOfCols;j++){
                if(grid[i][j] == '1'){
                    outlineIsland(grid, noOfRows, noOfCols, i, j);  
                    count ++;
                }
            }
        }
        return count;
    }
    
    private void outlineIsland(char[][]grid, int noOfRows, int noOfCols, int x, int y){
        
        if(x<0 || y<0 || x>=noOfRows || y>=noOfCols || grid[x][y] != '1'){
            return;
        }
        
        grid[x][y] = '2';
        countIslands(grid, noOfRows, noOfCols, x, y + 1);
        countIslands(grid, noOfRows, noOfCols, x + 1, y);
        countIslands(grid, noOfRows, noOfCols, x, y - 1);
        countIslands(grid, noOfRows, noOfCols, x - 1, y);
    }
}
