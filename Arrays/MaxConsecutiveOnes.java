class MaxConsecutiveOnes {
    //https://leetcode.com/problems/max-consecutive-ones/submissions/
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        
        int count =0;
        for(int no: nums){
            if(no == 1){
                count++;
                max = Math.max(max, count);
            }else{
                count = 0;
            }
                
        }
        return max;
    }
}
