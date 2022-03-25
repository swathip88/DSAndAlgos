class Solution {
    public static String solution(long[] arr) {
        // Type your solution here
        if(arr.length == 0){
            return "";
        }
        if(arr.length == 1){
            return "";
        }
        
        long lSum = sum(arr, 1);
        long rSum = sum(arr, 2);
        if(lSum > rSum){
            return "Left";
        }else if(lSum<rSum){
            return "Right";
        }else{
            return "";
        }
    }
    
    private static long sum(long[] arr, int index){
        long sum = 0;
        if(arr[index] != -1){
            sum = sum + arr[index];
        }
        int lChildIndex = index * 2 + 1;
        int rChildIndex = lChildIndex + 1;
        if(lChildIndex < arr.length){
            
            sum = sum + sum(arr,lChildIndex);
        }
        
        if(rChildIndex < arr.length){
            
            sum = sum + sum(arr,rChildIndex);
        }
        
        return sum;
    }
}
