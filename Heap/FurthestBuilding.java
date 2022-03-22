
class FurthestBuilding {
    //https://leetcode.com/problems/furthest-building-you-can-reach/submissions/

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        // Create a priority queue with a comparator that makes it behave as a min-heap.
        Queue<Integer> heap = new PriorityQueue<>((a, b) -> a - b);
        for(int i=0;i<heights.length-1;i++){
            int diff = heights[i + 1] - heights[i];
            if(diff <0){
                continue;
            }
            heap.add(diff);
            if(heap.size()<=ladders){
                continue;
            }
            bricks -= heap.remove();
            if(bricks<0){
                return i;
            }
        }
        
        return heights.length - 1;
    }
}
