class RemoveDuplicates {
    //https://leetcode.com/problems/remove-duplicates-from-sorted-array/submissions/
    public int removeDuplicates(int[] nums) {
     
        int length = nums.length;
        if(length < 2) return length;
        
        int i=0;
        int j=0;
        int repeatNo = nums[0];
        while(i<= length-1){
            if(nums[i] != repeatNo){
                if(j<i){
                    nums[j+1] = nums[i];
                }
                repeatNo = nums[i];
                j++;
            }
            else{
                i++;
            }
        }
        
        return j+1;
    }
}
