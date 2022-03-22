class CustomSortString {
    //https://leetcode.com/problems/custom-sort-string/submissions/
    public String customSortString(String order, String s) {
        
        //Get common letters
        //Rank the position of common letters
        
        List<Character> list = new ArrayList<>();
        for(int i=0;i<order.toCharArray().length;i++){
            for(int j=0;j<s.toCharArray().length;j++){
                if(order.charAt(i) == s.charAt(j)){
                    list.add(s.charAt(j));
                }
            }
        }
        Set<Character> set = new HashSet<>(list);
        
        StringBuilder builder = new StringBuilder();
        for(char c: list){
            builder.append(c);
        }
        
        for(char c:s.toCharArray()){
            if(!set.contains(c)){
                builder.append(c);
            }
        }
        
        return builder.toString();
    }
}
