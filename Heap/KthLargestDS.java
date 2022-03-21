class KthLargest {
    //https://leetcode.com/problems/kth-largest-element-in-a-stream/submissions/
    int k;
    PriorityQueue<Integer> queue;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>((n1, n2) -> n1 - n2);
        for(int num: nums){
            queue.add(num);
        }
        while(queue.size() >this.k){
            queue.poll();
        }
    }
    
    public int add(int val) {
        queue.add(val);
        if(queue.size()>this.k){
            queue.poll();
        }
        return queue.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
