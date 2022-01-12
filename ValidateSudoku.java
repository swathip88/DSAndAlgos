class ValidateSudoku {
    //https://leetcode.com/problems/valid-sudoku/submissions/
    public boolean isValidSudoku(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        if(rows != cols){
            return false;
        }
        
        // check each column
	for (int i = 0; i < 9; i++) {
		boolean[] m = new boolean[9];
		for (int j = 0; j < 9; j++) {
			if (board[i][j] != '.') {
				if (m[(int) (board[i][j] - '1')]) {
					return false;
				}
				m[(int) (board[i][j] - '1')] = true;
			}
		}
	}
 
	//check each row
	for (int j = 0; j < 9; j++) {
		boolean[] m = new boolean[9];
		for (int i = 0; i < 9; i++) {
			if (board[i][j] != '.') {
				if (m[(int) (board[i][j] - '1')]) {
					return false;
				}
				m[(int) (board[i][j] - '1')] = true;
			}
		}
	}
        
        
       
        
        
        for(int i=0;i<rows;i+=3){
            for(int j=0;j<cols;j+=3){
                boolean[] m = new boolean[9];
                if(board[i][j] != '.'){
                    if(m[(int)(board[i][j] - '1')]){
                        return false;
                    }
                    m[(int)board[i][j]- '1'] = true;
                }
                if(board[i+1][j] != '.'){
                    if(m[(int)board[i+1][j]- '1']){
                        return false;
                    }
                    m[(int)board[i+1][j]- '1'] = true;
                }
                if(board[i+2][j] != '.'){
                    if(m[(int)board[i+2][j]- '1']){
                        return false;
                    }
                    m[(int)board[i+2][j]- '1'] = true;
                }
                if(board[i][j+1] != '.'){
                    if(m[(int)board[i][j+1]- '1']){
                        return false;
                    }
                    m[(int)board[i][j+1]- '1'] = true;
                }
                if(board[i][j+2] != '.'){
                    if(m[(int)board[i][j+2]- '1']){
                        return false;
                    }
                    m[(int)board[i][j+2]- '1'] = true;
                }
                if(board[i+1][j+1] != '.'){
                    if(m[(int)board[i+1][j+1]- '1']){
                        return false;
                    }
                    m[(int)board[i+1][j+1]- '1'] = true;
                }
                if(board[i+1][j+2] != '.'){
                    if(m[(int)board[i+1][j+2]- '1']){
                        return false;
                    }
                    m[(int)board[i+1][j+2]- '1'] = true;
                }
                if(board[i+2][j+1] != '.'){
                    if(m[(int)board[i+2][j+1]- '1']){
                        return false;
                    }
                    m[(int)board[i+2][j+1]- '1'] = true;
                }
                if(board[i+2][j+2] != '.'){
                    if(m[(int)board[i+2][j+2]- '1']){
                        return false;
                    }
                    m[(int)board[i+2][j+2]- '1'] = true;
                }
            }
        }
        return true;
    }
}
