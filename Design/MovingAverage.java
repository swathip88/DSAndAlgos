class MovingAverage {
    //https://leetcode.com/problems/moving-average-from-data-stream/submissions/
    int size;
    List<Integer> list;
    int sum = 0;
    public MovingAverage(int size) {
        this.size = size;
        list = new ArrayList<>();
    }
    
    public double next(int val) {
        if(list.size() < this.size){
            list.add(val);
            sum+= val;
        }else{
            list.add(val);
            int first = list.remove(0);
            sum -=first;
            sum += val;
        }
        
        return (double)sum/(double)list.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
