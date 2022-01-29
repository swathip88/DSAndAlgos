class PeakIndexInMountain {
    //https://leetcode.com/problems/peak-index-in-a-mountain-array/submissions/
    public int peakIndexInMountainArray(int[] arr) {
        int length = arr.length;
        
        int mid = length /2;
        int low = 0;
        int high = arr.length -1;
        
        while(low<high){
            int prev = mid - 1;
            int next = mid + 1;
            if(prev <0 || next >= arr.length){
                return mid;
            }
            
            if(arr[mid]> arr[prev] && arr[mid]>arr[next]){
                return mid;
            }
            if(arr[mid]> arr[prev] && arr[next]> arr[mid]){
                low = mid;
                mid = (low + high)/2;
                
            }
            
            if(arr[mid]< arr[prev] && arr[next]< arr[mid]){
                high = mid;
                mid = (low + high)/2;
                
            }
        }
        
        return 0;
    }
}
