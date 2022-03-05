class RemoveElement {
    //https://leetcode.com/problems/remove-element/
    public int removeElement(int[] nums, int val) {
        int count= 0;
        
        int j =0;
        int i=0;
        
        while(i<nums.length){
            if(nums[i]!=val){
                nums[j]= nums[i];
                j++;
                i++;
            }else{
                i++;
                count++;
            }
        }
        
        return nums.length - count;
    }
}
