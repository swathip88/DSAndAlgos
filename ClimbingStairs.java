class ClimbingStairs {
    //https://leetcode.com/problems/climbing-stairs
    private Map<Integer, Integer> map = new HashMap<>();
    
    public int climbStairs(int n) {
        
        if(map.containsKey(n)) return map.get(n);
        
        if(n > 45) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;

        int sum = (climbStairs(n-1) + climbStairs(n -2));
        map.put(n, sum);
        return sum;
    }
    
    
}
