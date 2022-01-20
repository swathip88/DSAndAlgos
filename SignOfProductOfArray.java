class SignOfProductOfArray {
    //https://leetcode.com/problems/sign-of-the-product-of-an-array/submissions/
    public int arraySign(int[] nums) {
        int x = 0;
        boolean isZero = false;
        for(int i=0;i<nums.length;i++){
            if(nums[i] < 0){
                x++;
            }
            if(nums[i] == 0){
                isZero=true;
                break;
            }
        }
        if(isZero){
            return 0;
        }
        if(x %2 == 0){
            return 1;
        }else{
            return -1;
        }
    }
}
