class Combinations {
    //https://leetcode.com/problems/combinations/submissions/
    List<List<Integer>> ans = new LinkedList<>();
    int n;
    int k;
    
    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        backtrack(1, new LinkedList<Integer>());
        return this.ans;
    }
    
    private void backtrack(int first, LinkedList<Integer> temp){
        if(temp.size() == k){
            ans.add(new LinkedList<>(temp));
        }
        
        for(int i=first;i<=n;i++){
            temp.add(i);
            backtrack(i + 1, temp);
            temp.removeLast();
        }
    }
}
