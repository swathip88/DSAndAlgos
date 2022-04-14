class SortedSquares {
    //https://leetcode.com/problems/squares-of-a-sorted-array/submissions/
    public int[] sortedSquares(int[] nums) {
        int i= 0;
        int length = nums.length;
        int[] ans = new int[length];
        for(i =0 ;i<length; i++){
            if(nums[i] >=0){
                break;
            }
        }
        
        for(int j=0;j<length;j++){
            nums[j] = nums[j]*nums[j];
        }
        
        int j =i-1;
        int k=i;
        int m = 0;
        while(j>=0 && k<length){
            if(nums[j] < nums[k]){
                ans[m] = nums[j]; 
                j--;
            }else{
                ans[m] = nums[k]; 
                k++;
            } 
            m++;
        }
        
        if(j>=0){
            while(j>=0){
                ans[m] = nums[j];
                m++;
                j--;
            }
        }
        
        
        if(k<length){
            while(k<length){
                ans[m] = nums[k];
                m++;
                k++;
            }
        }
        
        return ans;
    }
}
