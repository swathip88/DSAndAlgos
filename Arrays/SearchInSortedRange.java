class SearchInSortedRange {
  //https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/submissions/
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        if(nums.length==0){
            ans[0] = -1;
            ans[1] = -1;
            return ans;
        }
        
        int low = 0;
        int high = nums.length-1;
        int mid = (low +high) /2;
        while(low < high){
            if(nums[mid] == target){
                break;
            }else if(nums[mid]>target){
                high = mid-1;
                mid = (low + high)/2;
            }else{
                low = mid+1;
                mid = (low + high)/2;
            }
        }
        
        if(nums[mid] != target){
            ans[0] = -1;
            ans[1] = -1;
            return ans;
        }
        
        int a = mid;
        
        while(a >=0){
            if(nums[a] == target){
                a--;
            }else{
                break;
            }
        }
        ans[0] = a+1;
        
        a = mid;
        while(a< nums.length){
            if(nums[a] == target){
                a++;
            }else{
                break;
            }
        }
        ans[1] = a - 1;
        
        return ans;
            
    }
}
