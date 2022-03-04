class MajorityElementII {
    //https://leetcode.com/problems/majority-element-ii/submissions/
    public List<Integer> majorityElement(int[] nums) {
        Set<Integer> ans = new HashSet<>();
        if(nums.length==0){
            return new ArrayList<>();
        }
        int oneThird = nums.length / 3 + 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            
            if(map.containsKey(nums[i]) && !ans.contains(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            }else{
                map.put(nums[i], 1);
            }
            
            if(map.get(nums[i]) >= oneThird){
                ans.add(nums[i]);
            }
        }
        
        return new ArrayList<Integer>(ans);
    }
}
