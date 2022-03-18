class NoOfProvinces {
    //https://leetcode.com/problems/number-of-provinces/submissions/
    public int findCircleNum(int[][] isConnected) {
        int[] visited = new int[isConnected.length];
        int count = 0;
        for(int i=0;i<visited.length;i++){
            if(visited[i] == 0){
                dfs(isConnected, visited, i);
                count++;
            }
        }
        
        return count;
    }
    
    private void dfs(int[][]m, int[] visited, int i){
        for(int j=0; j<m.length;j++){
            if(m[i][j] ==1 && visited[j] ==0){
                visited[j] = 1;
                dfs(m, visited, j);
            } 
        }
    }
}
