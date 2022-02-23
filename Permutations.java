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
