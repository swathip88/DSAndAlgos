class LastStoneWeight {
    //https://leetcode.com/problems/last-stone-weight/submissions/
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> n2 - n1);
        if(stones.length ==0){
            return 0;
        }
        if(stones.length ==1){
            return stones[0];
        }
        int ans = 0;
        for(int num: stones){
            heap.add(num);
        }
        
        while(!(heap.isEmpty()) && heap.size()>1){
            int x = heap.poll();
            int y = heap.poll();
            if(x == y){
                
            }else{
                int newStone = Math.abs(x-y);
                heap.add(newStone);
            }
        }
        
        if(heap.isEmpty()){
            return 0;
        }else{
            return heap.peek();    
        }
        
    }
}
