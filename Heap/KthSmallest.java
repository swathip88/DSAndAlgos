class KthSmallest {
    //https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/submissions/
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1,n2) -> n2 - n1);
        
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                heap.add(matrix[i][j]);
                if(heap.size() > k){
                    heap.poll();
                }
            }
        }
        return heap.peek();
    }
}
