class EquivalentDominoes {
    //https://leetcode.com/problems/number-of-equivalent-domino-pairs/submissions/
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<String, List<int[]>> map = new HashMap<>();
        
        for(int[] domino: dominoes){
            int a = domino[0];
            int b = domino[1];
            String s = "";
            if(a<b){
                s = a + "," + b;
            }else{
                s = b + "," + a;
            }
            
            if(map.containsKey(s)){
                map.get(s).add(domino);
            }else{
                List<int[]> l = new ArrayList<int[]>();
                l.add(domino);
                map.put(s, l);
            }
        }
        
        Iterator i = map.keySet().iterator();
        int ans = 0;
        while(i.hasNext()){
            String s = (String)i.next();
            int size = map.get(s).size();
            ans = ans + ((size* (size-1))/2);
        }
        return ans;
    }
}
