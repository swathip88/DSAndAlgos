class JewelsAndStones {
    //https://leetcode.com/problems/jewels-and-stones/submissions/
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> j = new HashSet<>();
        for(char c: jewels.toCharArray()){
            j.add(c);
        }
        int count = 0;
        
        for(char c:stones.toCharArray()){
            if(j.contains(c)){
                count++;
            }
        }
        
        return count;
    }
}
