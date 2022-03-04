class FindPeakElement {
    //https://leetcode.com/problems/find-peak-element/submissions/
    public int findPeakElement(int[] nums) {
        
        return search(nums, 0, nums.length -1);
    }
    
    private int search(int[] nums, int l, int r){
        if(l == r){
            return l;
        }
        int mid = (l + r)/2;
        if(nums[mid] > nums[mid + 1]){
            return search(nums, l, mid);
        }else{
            return search(nums, mid+ 1, r);
        }
    }
}
