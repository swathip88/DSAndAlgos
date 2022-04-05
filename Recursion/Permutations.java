class Permutations {
    
  //https://leetcode.com/problems/permutations/submissions/
  public List<List<Integer>> permute(int[] nums) {
    // init output list
    List<List<Integer>> output = new ArrayList<>();

    ArrayList<Integer> list = new ArrayList<Integer>();
    for(int i=0;i<nums.length;i++){
        list.add(nums[i]);
    }
      
    if(list.size() == 1){
        output.add(list);
        return output;
    }
    
      
    for(int i=0;i<list.size();i++){
        int no = list.get(i);
        List<Integer> copy = list.stream()
        .collect(Collectors.toList());
        copy.remove(i);
        
        int[] primitive = copy.stream()
                            .mapToInt(Integer::intValue)
                            .toArray();
        
        List<List<Integer>> tempOutput = permute(primitive);
        for(int j=0;j<tempOutput.size();j++){
            tempOutput.get(j).add(no);
        }
        output.addAll(tempOutput);
   }
    return output;
  }
}

class Solution {
  public void backtrack(int n,
                        ArrayList<Integer> nums,
                        List<List<Integer>> output,
                        int first) {
    // if all integers are used up
    if (first == n)
      output.add(new ArrayList<Integer>(nums));
    for (int i = first; i < n; i++) {
      // place i-th integer first 
      // in the current permutation
      Collections.swap(nums, first, i);
      // use next integers to complete the permutations
      backtrack(n, nums, output, first + 1);
      // backtrack
      Collections.swap(nums, first, i);
    }
  }

  public List<List<Integer>> permute(int[] nums) {
    // init output list
    List<List<Integer>> output = new LinkedList();

    // convert nums into list since the output is a list of lists
    ArrayList<Integer> nums_lst = new ArrayList<Integer>();
    for (int num : nums)
      nums_lst.add(num);

    int n = nums.length;
    backtrack(n, nums_lst, output, 0);
    return output;
  }
}
