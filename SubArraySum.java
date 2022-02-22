class SubArraySum {
    //https://leetcode.com/problems/subarray-sum-equals-k/
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count =0;
        int sum =0;
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            int no = nums[i];
            sum = sum + no;
            if(map.containsKey(sum -k)){
                count = count + map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
            
            
        return count;
    }
}
