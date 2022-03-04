/*
Proper Solution
Create a recursive function that takes two arrays and the sizes of both the arrays.
Take care of the base cases for the size of arrays less than 2. (previously discussed in Approach).Note: The first array is always the smaller array.
Find the middle elements of both the arrays. i.e element at (n – 1)/2 and (m – 1)/2 of first and second array respectively. Compare both the elements.
If the middle element of the smaller array is less than the middle element of the larger array then the first half of the smaller array is bound to lie strictly in the first half of the merged array. It can also be stated that there is an element in the first half of the larger array and the second half of the smaller array which is the median. So, reduce the search space to the first half of the larger array and the second half of the smaller array.
Similarly, If the middle element of the smaller array is greater than the middle element of the larger array then reduce the search space to the first half of the smaller array and second half of the larger array.
*/  
  
  class MedianOfSortedArrays {
    //The most efficient solution is mentioned above.
    //https://leetcode.com/problems/median-of-two-sorted-arrays/
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l = nums1.length + nums2.length;
        int[] merged = new int[l];
        
        int i=0;
        int j=0;
        int k=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]< nums2[j]){
                merged[k] = nums1[i];
                i++;
            }else{
                merged[k] = nums2[j];
                j++;
            }
            k++;
        }
        
        while(i<nums1.length){
            merged[k] = nums1[i];
            i++;
            k++;
        }
        
        while(j<nums2.length){
            merged[k] = nums2[j];
            j++;
            k++;
        }
        double ans = 0.0;
        if(l%2 == 0){
            int a = merged[(l/2) - 1];
            int b = merged[l/2];
            
            ans = (new Double(a) + new Double(b))/2;
        }else{
            ans = merged[l/2];
        }
        
        return ans;
    }
}
