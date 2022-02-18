class IntersectionOfTwoArraysII {
    //https://leetcode.com/problems/intersection-of-two-arrays-ii/
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);


        int j=0;
        int k=0;
        ArrayList<Integer> list = new ArrayList<>();

        while(j<nums1.length && k<nums2.length){
            if(nums1[j] == nums2[k]){
                list.add(nums1[j]);
                j++;
                k++;
            }else if(nums1[j] < nums2[k]){
                j++;
            }else if(nums2[k] < nums1[j]){
                k++;
            }
        }
        int[] arr = list.stream().mapToInt(m -> m).toArray();
        return arr;
    }
}
