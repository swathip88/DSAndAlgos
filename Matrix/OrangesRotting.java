class OrangesRotting {
    //https://leetcode.com/problems/rotting-oranges/submissions/
    public int orangesRotting(int[][] grid) {
        int ans = 0;
        boolean noChange = false;
        int rows = grid.length;
        int cols = grid[0].length;
        while (!noChange){
            noChange = true;
            for(int i=0;i<rows;i++){
                for(int j=0;j<cols;j++){
                    int val = grid[i][j];
                    if(val == 2){
                        //Rot other oranges
                        int up = i-1;
                        int down = i+1;
                        int left = j-1;
                        int right = j+1;
                        if(up>=0 && grid[up][j] == 1){
                            noChange = false;
                            grid[up][j] = 3;
                        }
                        if(down<rows && grid[down][j] == 1){
                            noChange = false;
                            grid[down][j] = 3;
                        }
                        if(left>=0 && grid[i][left] == 1){
                            noChange = false;
                            grid[i][left] = 3;
                        }
                        if(right<cols && grid[i][right] == 1){
                            noChange = false;
                            grid[i][right] = 3;
                        }
                    }
                }
            }
            
            for(int i=0;i<rows;i++){
                for(int j=0;j<cols;j++){
                    if(grid[i][j] == 3){
                        grid[i][j] = 2;
                    }
                }
            }
            ans++;
        }
        
        boolean allRotten = true;
        for(int i=0;i<rows;i++){
                for(int j=0;j<cols;j++){
                    if(grid[i][j] == 1){
                        allRotten = false;
                    }
                }
            }
        if(allRotten){
            return ans-1;    
        }else{
            return -1;
        }
        
    }
}
