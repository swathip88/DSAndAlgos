class PartitionLabels {
    //https://leetcode.com/problems/partition-labels/submissions/
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, int[]> intervals = new HashMap<>();
        HashMap<Integer, Character> reverse = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(intervals.containsKey(c)){
                intervals.get(c)[1] = i;
            }else{
                int[] arr = new int[2];
                arr[0] = i;
                intervals.put(c, arr);
                reverse.put(i, c);
            }
        }
        
        ArrayList<int[]> x = new ArrayList<>(intervals.values());
        for(int i=0;i<x.size();i++){
            if(x.get(i)[1] ==0){
                x.get(i)[1] = x.get(i)[0];
            }
        }
        
        //Merge intervals
        Collections.sort(x, (a,b) -> Integer.compare(a[0], b[0]));
        
        LinkedList<int[]> merged = new LinkedList<>();
        
        for(int[] interval: x){
            if(merged.isEmpty()){
                merged.add(interval);
            }else if (merged.getLast()[1]< interval[0]){
                merged.add(interval);
            }else{
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
                
        }
        
        List<Integer> list = new ArrayList<>();
        for(int[] mergedInterval: merged){
            list.add(mergedInterval[1] - mergedInterval[0] + 1);
        }
        
        return list;
        
    }
}
