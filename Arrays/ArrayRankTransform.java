class ArrayRankTransform {
    //https://leetcode.com/problems/rank-transform-of-an-array/submissions/
    public int[] arrayRankTransform(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int[] sorted = new int[arr.length];
        
        for(int i=0;i<arr.length;i++){
            sorted[i] = arr[i];
        }
        
        
        Arrays.sort(sorted);
        int rank = 1;
        for(int i=0;i<sorted.length;i++)
        {
            if(map.containsKey(sorted[i])){
                
            }else{
                map.put(sorted[i], rank);
                rank++;
            }
        }
        
        for(int i=0;i<arr.length;i++){
            arr[i] = map.get(arr[i]);
        }
        
        return arr;
    }
}
