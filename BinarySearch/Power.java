class Power {
    //https://leetcode.com/problems/powx-n/submissions/
    public double myPow(double x, int n) {
        if(n<0){
            x = 1/x;
            n = -n;
        }
        return pow(x,n);
    }
    
    private double pow(double x, long n){
        if(n == 0){
            return 1.0;
        }
        double half = pow(x, n/2);
        if(n%2==0){
            half = half * half;
        }else{
            half = half * half * x;
        }
        return half;
    }
}
