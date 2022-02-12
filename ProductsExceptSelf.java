class ProductsExceptSelf {
    //https://leetcode.com/problems/product-of-array-except-self/submissions/
    public int[] productExceptSelf(int[] nums) {
        
       int length = nums.length;
       int[] prevProducts = new int[length];
       int[] afterProducts = new int[length];
        
        for(int i=0;i<length;i++){
            prevProducts[i] = 1;
            afterProducts[i] = 1;
        }
        
        for(int i=1;i<length;i++){
            prevProducts[i] = prevProducts[i-1] * nums[i-1];
        }
        
        for(int i=length-2;i>=0;i--){
            afterProducts[i] = afterProducts[i+1] * nums[i+1];
        }
        
        for(int i=0;i<length;i++){
            prevProducts[i] = prevProducts[i] * afterProducts[i];
        }
        
        return prevProducts;
    }
}
