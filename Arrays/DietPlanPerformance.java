class DietPlanPerformance {
    //https://leetcode.com/problems/diet-plan-performance/submissions/
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int ans =0;
        int i =0;
        int sum = 0;
        for(i=0;i<k;i++){
            sum+= calories[i];
        }
        if(sum<lower){
            ans--;
        }else if(sum>upper){
            ans++;
        }
        
        for(i=i;i<calories.length;i++){
            sum = sum - calories[i-k] + calories[i];
            
            if(sum<lower){
                ans--;
            }else if(sum>upper){
                ans++;
            }
        }
            
        return ans;
    }
}
