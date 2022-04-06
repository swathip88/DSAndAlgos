public class WordLocation {
  
  public static void main(String[] argv) {
    char[][] grid1 = {
      {'c', 'c', 'x', 't', 'i', 'b'},
      {'c', 'c', 'a', 't', 'n', 'i'},
      {'a', 'c', 'n', 'n', 't', 't'},
      {'t', 'c', 's', 'i', 'p', 't'},
      {'a', 'o', 'o', 'o', 'a', 'a'},
      {'o', 'a', 'a', 'a', 'o', 'o'},
      {'k', 'a', 'i', 'c', 'k', 'i'}
    };
    String word1 = "catnip";
    String word2 = "cccc";
    String word3 = "s";
    String word4 = "bit";
    String word5 = "aoi";
    String word6 = "ki";
    String word7 = "aaa";
    String word8 = "ooo"; 

    char[][] grid2 = {{'a'}};
    String word9 = "a";

    char[][] grid3 = {
    {'c','a','t'},
    {'b','a','t'}
  };

    List<String> ans= find_word_location(grid2, word9);

    for(String a: ans){
      System.out.println(a);
    }

  }

  
  private static List<String> find_word_location(char[][]grid, String word){
    for(int i=0;i<grid.length;i++){
      for(int j=0;j<grid[0].length;j++){
        List<String> ans = new ArrayList<>();
        dfs(grid, i, j, word, 0, ans);
        System.out.println("Inside for loop:"+ans.size());
        if(ans.size() == word.length()){
          return ans;
        }
      }
    }
    return null;
  }
/*
char[][] grid1 = {
      {'c', 'c', 'x', 't', 'i', 'b'},
      {'c', 'c', 'a', 't', 'n', 'i'},
      {'a', 'c', 'n', 'n', 't', 't'},
      {'t', 'c', 's', 'i', 'p', 't'},
      {'a', 'o', 'o', 'o', 'a', 'a'},
      {'o', 'a', 'a', 'a', 'o', 'o'},
      {'k', 'a', 'i', 'c', 'k', 'i'}
    };
*/
  private static void dfs(char[][]grid, int x, int y, String word, int charNo, List<String> ans){
    if(grid[x][y] != word.charAt(charNo)){
      return;
    }
    System.out.println(x+","+y);
    
    ans.add(x+","+y);
    System.out.println(ans.size());
    if(charNo == word.length() - 1){
      return;
    }

    if(y+1 <grid[0].length){
      dfs(grid, x, y+1, word, charNo+1, ans);

    }

    if(x+1 <grid.length){
      dfs(grid, x+1, y, word, charNo+1, ans);
      
    }
    if(ans.size() != word.length())
      ans.remove(ans.size()-1);
    return;
  }
}
