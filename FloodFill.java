class FloodFill {
    //https://leetcode.com/problems/flood-fill/submissions/
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        int noOfRows = image.length;
        int noOfCols = image[0].length;
        if(sr >=0 && sr<noOfRows && sc>=0 && sc<noOfCols){
            int oldColor = image[sr][sc];
            image[sr][sc] = newColor;
            
            
            if(noOfRows > sr+1){
                if(image[sr+1][sc] == oldColor && image[sr+1][sc] != newColor){
                    floodFill(image, sr+1, sc, newColor);
                }
            }
            if(noOfCols > sc+1){
                if(image[sr][sc+1] == oldColor && image[sr][sc+1] != newColor ){
                    floodFill(image, sr, sc+1, newColor);
                }
            }
            if(0 <= sc-1){
                if(image[sr][sc-1] == oldColor && image[sr][sc-1] != newColor){
                    floodFill(image, sr, sc-1, newColor);
                }
            }
            if(0 <= sr-1){
                if(image[sr-1][sc] == oldColor && image[sr-1][sc] != newColor){
                    floodFill(image, sr-1, sc, newColor);
                }
            }
            return image;
        }else{
            return image;
        }
        
        
    }
}
