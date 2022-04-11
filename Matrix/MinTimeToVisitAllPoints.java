//https://leetcode.com/problems/minimum-time-visiting-all-points/submissions/
class MinTimeToVisitAllPoints {
    public int minTimeToVisitAllPoints(int[][] points) {
        int min = 0;
        
        for(int i=0;i<points.length-1;i++){
            int timeX = Math.abs(points[i][0] - points[i+1][0]);
            int timeY = Math.abs(points[i][1] - points[i+1][1]);
            min += Math.max(timeX, timeY);
        }
        
        return min;
    }
}
