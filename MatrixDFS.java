class MatrixDFS {
    //https://leetcode.com/problems/word-search/submissions/
    public boolean exist(char[][] board, String word) {
        
        int r = board.length;
        int c = board[0].length;
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(dfs(board, word, 0, i, j)){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int index, int a, int b){
        if(a < 0 || b< 0 || a>=board.length || b>= board[0].length){
            return false;
        }
        
        if(board[a][b] == word.charAt(index)){
            char temp = board[a][b];
            board[a][b] = '#';
            if(index == word.length()-1){
                return true;
            }else if(dfs(board, word, index+1, a-1, b)
            ||dfs(board, word, index+1, a+1, b)
            ||dfs(board, word, index+1, a, b+1)
            ||dfs(board, word, index+1, a, b-1)){
                return true;
            }
            board[a][b] = temp;
        }
        return false;
    }
}
