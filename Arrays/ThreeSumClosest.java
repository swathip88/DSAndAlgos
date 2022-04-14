class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        //https://leetcode.com/problems/3sum-closest/
        Arrays.sort(nums);
        
        int closestValue = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            int j= i + 1;
            int k = nums.length - 1;
            while(j < k){
                
                int value = nums[i] + nums[j] + nums[k];
                
                int curValue = Math.abs(target - value);
                
                if(curValue< closestValue){
                    closestValue = curValue;
                    result = value;
                }
                
                if(value <target){
                    j++;
                }else{
                    k--;
                }
            }
        }
        return result;
    }
    
}
