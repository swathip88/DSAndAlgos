class CourseScheduleI {
    //https://leetcode.com/problems/course-schedule/submissions/
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjacencyMap = new HashMap<>();
        Map<Integer, Integer> inDegreeMap = new HashMap<>();
        for(int i=0;i<numCourses;i++) {
            adjacencyMap.put(i, new ArrayList<>());
            inDegreeMap.put(i,0);
        }
        
        for(int[] preReq: prerequisites){
            int a = preReq[0];
            int b = preReq[1];
            adjacencyMap.get(a).add(b);
            int newIndegree = inDegreeMap.get(b) + 1;
            inDegreeMap.put(b, newIndegree);
        }
        
        while(!inDegreeMap.isEmpty()){
            int i =0;
            for(i=0;i<numCourses;i++){
                if(inDegreeMap.containsKey(i) && inDegreeMap.get(i) == 0){
                    break;
                }
            }
            if(i == numCourses){
                return false;
            }
            inDegreeMap.remove(i);
            List<Integer> adjacentCourses = adjacencyMap.get(i);
            for(int adjCourse: adjacentCourses){
                inDegreeMap.put(adjCourse, inDegreeMap.get(adjCourse) - 1);
            }
        }
        
        return true;
    }
}
