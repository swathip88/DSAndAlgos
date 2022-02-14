class ContiguousBinarySubArray {
    //https://leetcode.com/problems/contiguous-array/submissions/
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> counts = new HashMap<Integer,Integer>();
        int ans = 0;
        int count = 0;
        counts.put(0, -1);
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                count += -1;
            }else{
                count += 1 ;
            }
            
            if(counts.containsKey(count)){
                ans = Math.max(ans, i - counts.get(count));
                
            }else{
                counts.put(count, i);
            }
        }
        
        return ans;
    }
}
