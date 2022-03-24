class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        //https://leetcode.com/problems/3sum/submissions/
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int j= i + 1;
            int k = nums.length - 1;
            while(j < k){
                if(nums[i] + nums[j] + nums[k] == 0){
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(nums[k]);
                    set.add(triplet);
                    j++;
                    k--;
                }else if(nums[i] + nums[j] + nums[k] >0){
                    k--;
                }else if(nums[i] + nums[j] + nums[k] <0){
                    j++;
                }
            }
        }
        ans.addAll(set);
        return ans;
    }
}
