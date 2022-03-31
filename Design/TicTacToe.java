class TicTacToe {
    //https://leetcode.com/problems/design-tic-tac-toe/submissions/
    char[][]board;
    int n;
    public TicTacToe(int n) {
        this.n = n;
        board = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                this.board[i][j] = '-';
            }
        }
    }
    
    public int move(int row, int col, int player) {
        char c = '-';
        if(player ==1){
            c = 'X';
        }else{
            c = 'O';
        }
        this.board[row][col] = c;
        
        return (colCheck(row, col, c) ||rowCheck(row, col, c) || diagonalCheck(row, col, c) || diagonalCheck2(row, col, c)) ?player:0 ;
    }
    
    private boolean colCheck(int row, int col, char c){
        char[][]xc = this.board;
        for(int i=0;i<this.n;i++){
            if(this.board[i][col] != c){
                return false;
            }
        }
        return true;
    }
    
    private boolean rowCheck(int row, int col, char c){
        for(int i=0;i<this.n;i++){
            if(this.board[row][i] != c){
                return false;
            }
        }
        return true;
    }
    
    private boolean diagonalCheck(int row, int col, char c){
        if(row == col){
            for(int i=0;i<this.n;i++){
                if(this.board[i][i] != c){
                    return false;
                }
            }
        }else{
            return false;
        }
        
        return true;
    }
    
    private boolean diagonalCheck2(int row, int col, char c){
        char[][]a = this.board;
        int j = this.n-1;
        for(int i=0;i<this.n;i++){
            if(this.board[i][j] != c){
                    return false;
            }
            j--;
        }
        return true;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
