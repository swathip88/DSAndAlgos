class KClosestPoints {
    //https://leetcode.com/problems/k-closest-points-to-origin/submissions
    public int[][] kClosest(int[][] points, int k) {
        Map<Double, ArrayList<int[]>> map = new HashMap<>();
        
        
        for(int[] point: points){
            int x = point[0];
            int y = point[1];
            double d = Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
            int[] arr = new int[2];
            arr[0] = x;
            arr[1] = y;
            if(map.containsKey(d)){
                map.get(d).add(arr);
            }else{
                ArrayList<int[]> list = new ArrayList<>();
                list.add(arr);
                map.put(d,list);    
            }
            
        }
        
        List<Double> allDistances = map.keySet().stream().sorted().collect(Collectors.toList());
        
        ArrayList<int[]> finalList = new ArrayList<>();
        
        int count = k;
        for(double d: allDistances){
            ArrayList<int[]> l = map.get(d);
            if(count< finalList.size()){
                for(int[] c: l){
                    finalList.add(c);
                }
                count = count - l.size();
            }else{
                finalList.addAll(l);
                count = count - l.size();
            }
            if(count ==0){
                break;
            }
        }
        
        int[][] ans = new int[k][];
        ans = finalList.toArray(ans);
        
        return ans;
    }
}
