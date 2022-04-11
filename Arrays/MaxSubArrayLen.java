class MaxSubArrayLen {
    //https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/
    public int maxSubArrayLen(int[] nums, int k) {
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum =0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            if(sum == k){
                max = i +1;
            }
            
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
            
            if(map.containsKey(sum - k)){
                max = Math.max(max , i-map.get(sum-k));
            }
        }
        
        return max;
    }
}
