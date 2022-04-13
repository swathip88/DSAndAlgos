class Solution {
    //https://leetcode.com/problems/game-of-life/submissions/
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int cell = board[i][j];
                int noOfNeighbors = isLive(board, i-1,j-1) + isLive(board, i-1,j) + 
                    isLive(board, i-1,j+1) + isLive(board, i,j-1) +
                    isLive(board, i,j+1) + isLive(board, i+1,j-1) +
                    isLive(board, i+1,j) + isLive(board, i+1,j+1);
                
                if(cell ==1){
                    if(noOfNeighbors<2 || noOfNeighbors>3){
                        board[i][j] = 2;
                    }
                }
                
                if(cell ==0){
                    if(noOfNeighbors==3){
                        board[i][j] = 3;
                    }
                }
            }
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == 2){
                    board[i][j] = 0;
                }else if(board[i][j] == 3){
                    board[i][j] = 1;
                }
            }
        }
    }
    
    
    private int isLive(int[][]board, int x, int y){
        if(x < 0 || y<0 || x>= board.length || y>= board[0].length){
            return 0;
        }else{
            if(board[x][y] == 2 || board[x][y] == 1){
                return 1;
            }else{
                return 0;
            }
        }
    }
}
