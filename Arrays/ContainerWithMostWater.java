class ContainerWithMostWater {
    //https://leetcode.com/problems/container-with-most-water/
    public int maxArea(int[] height) {
        int length = height.length;
        int l = 0;
        int r = length -1;
        int max = Math.abs((r-l) * (Math.min(height[l], height[r])));
        
        while(l<r){
            if(height[l]<height[r]){
                l++;
            }else{
                r--;
            }
            max = Math.max(max, Math.abs((l-r) * (Math.min(height[l], height[r]))));
        }
        
        return max;
            
    }
}
