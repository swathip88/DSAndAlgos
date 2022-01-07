class MissingNumber {
    //https://leetcode.com/problems/missing-number/submissions/
    public int missingNumber(int[] nums) {
     
        int length = nums.length;
        boolean isZeroPresent = false;
        int sum = 0;
        for(int i=0;i<length;i++){
            if(nums[i] == 0){
                isZeroPresent = true;
            }
            sum = sum + nums[i];
        }
        
        if(!isZeroPresent){
            return 0;
        }
        
        int total = ((length) * (length+1))/2;
        
        return total - sum;
    }
}
