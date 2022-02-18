class MoveZeroes {
    //https://leetcode.com/problems/move-zeroes/submissions/
    public void moveZeroes(int[] nums) {
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                count++;
            }
        }
        
        int i=0;
        int j=0;
        while(i<nums.length){
            if(nums[i] == 0){
                i++;
            }else{
                if(j<i){
                    nums[j] = nums[i];
                }
                j++;
                i++;
            }
        }
        
        while(j<nums.length){
            nums[j] = 0;
            j++;
        }
    }
}