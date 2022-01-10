class SearchSortedMatrix {
    //https://leetcode.com/problems/search-a-2d-matrix/
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        if(target > matrix[rows-1][cols-1]){
            return false;
        }
        //figure out which row to check
        
        int low = 0;
        int high = rows - 1;
        int mid = (low + high)/2;
        while(low <high){
            if(matrix[mid][cols-1] == target){
                return true;
            }
            else if(matrix[mid][cols-1] < target){
                low = mid+1;
                mid = (low + high)/2;
                
            }else{
                high = mid;
                mid = (low + high)/2;
            }
        }
        
        int rowNo = mid;
        low = 0;
        high = cols-1;
        mid = (low + high)/2;
        while(low <=high){
            if(matrix[rowNo][mid] == target){
                return true;
            }
            else if(matrix[rowNo][mid]  < target){
                low = mid+1;
                mid = (low + high)/2;
            }else{
                high = mid-1;
                mid = (low + high)/2;
                
            }
        }
        
        return false;
    }
}
