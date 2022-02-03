public class ReverseBits {
    //https://leetcode.com/problems/reverse-bits/submissions/
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        int mask = 1;
        for(int i=0;i<32;i++){
            int a = n & mask;
            res = res << 1;
            if (a!=0){
                res = res + 1;
            }
            mask = mask << 1;
        }
        return res;
    }
}
