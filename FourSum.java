class FourSum {
    //https://leetcode.com/problems/4sum/submissions/
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i=0;i<nums.length-1;i++){
            int val = nums[i];
            int newTarget = target-nums[i];
            int[] a = Arrays.copyOfRange(nums, i+1, nums.length);
            List<List<Integer>> threeSumResults = threeSum(a, newTarget);
            for(int j=0;j<threeSumResults.size();j++){
                List<Integer> quadruple = new ArrayList<>();
                quadruple.add(nums[i]);
                quadruple.add(threeSumResults.get(j).get(0));
                quadruple.add(threeSumResults.get(j).get(1));
                quadruple.add(threeSumResults.get(j).get(2));
                set.add(quadruple);
            }
        }
        ans.addAll(set);
        return ans;
    }
    
    public List<List<Integer>> threeSum(int[] nums, int target) {
        //https://leetcode.com/problems/3sum/submissions/
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int j= i + 1;
            int k = nums.length - 1;
            while(j < k){
                if(nums[i] + nums[j] + nums[k] == target){
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(nums[k]);
                    set.add(triplet);
                    j++;
                    k--;
                }else if(nums[i] + nums[j] + nums[k] >target){
                    k--;
                }else if(nums[i] + nums[j] + nums[k] <target){
                    j++;
                }
            }
        }
        ans.addAll(set);
        return ans;
    }
}
