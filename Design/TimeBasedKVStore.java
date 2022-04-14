class TimeMap {
    //https://leetcode.com/problems/time-based-key-value-store/
    Map<String, TreeMap<Integer, String>> map;
    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(this.map.containsKey(key)){
            map.get(key).put(timestamp, value);
        }else{
            TreeMap<Integer, String> m = new TreeMap<>();
            m.put(timestamp, value);
            map.put(key, m);
        }
    }
    
    public String get(String key, int timestamp) {
        if(this.map.containsKey(key)){
            TreeMap<Integer, String> m = map.get(key);
            if(m.containsKey(timestamp)){
                return m.get(timestamp);
            }else{
                
                Integer k = m.lowerKey(timestamp);
                if(k == null){
                    return "";
                }
                return m.get(k.intValue());
            }
        }else{
            return "";
        }
    }
}


/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
