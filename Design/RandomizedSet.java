class RandomizedSet {
    //https://leetcode.com/problems/insert-delete-getrandom-o1/solution/
    Map<Integer, Integer> map;
    Random rand = new Random();
    public RandomizedSet() {
        map = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }else{
            map.put(val, val);
            return true;
        }
    }
    
    public boolean remove(int val) {
        if(map.containsKey(val)){
            map.remove(val);
            return true;
        }else{
            return false;
        }
    }
    
    public int getRandom() {
        List<Integer> values = new ArrayList<>(map.values());
        
        return values.get(rand.nextInt(values.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
