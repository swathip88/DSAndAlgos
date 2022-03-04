class MajorityElement {
    //https://leetcode.com/problems/majority-element/submissions/
    public int majorityElement(int[] nums) {
        int maxCount = 1;
        int ans = nums[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                int newCount = map.get(nums[i]) + 1;
                map.put(nums[i], newCount);
                if(newCount > maxCount){
                    maxCount = newCount;
                    ans = nums[i];
                }
            }else{
                map.put(nums[i], 1);
            }
        }
        return ans;
    }
}
