class SortColors {
    //https://leetcode.com/problems/sort-colors/submissions/
    public void sortColors(int[] nums) {
        int noOfZeroes = 0;
        int noOfOnes = 0;
        int noOfTwos = 0;
        
        for(int i=0;i<nums.length;i++){
            if(nums[i] ==0){
                noOfZeroes++;
            }else if(nums[i] ==1){
                noOfOnes++;
            }
            else{
                noOfTwos++;
            }
        }
      
        for(int i=0;i<noOfZeroes;i++){
            nums[i] = 0;
        }
    
        
        for(int i=noOfZeroes;i<(noOfOnes+noOfZeroes);i++){
            nums[i] = 1;
        }
    
        for(int i=noOfOnes+noOfZeroes;i<(noOfTwos+noOfOnes+noOfZeroes);i++){
            nums[i] = 2;
        }
    }
}
