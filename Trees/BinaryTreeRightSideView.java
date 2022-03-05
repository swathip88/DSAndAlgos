/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BinaryTreeRightSideView {
    //https://leetcode.com/problems/binary-tree-right-side-view/submissions/
    public List<Integer> rightSideView(TreeNode root) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        populateMap(root, map, 0);
        List<Integer> sortedKeys = map.keySet().stream().sorted().collect(Collectors.toList());
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<sortedKeys.size();i++){
            List<Integer> temp = map.get(sortedKeys.get(i));
            ans.add(temp.get(temp.size()-1));
        }
        
        return ans;
    }
    
    private void populateMap(TreeNode root, HashMap<Integer,List<Integer>> map, int depth){
        if(root ==null){
            return;
        }
        if(map.containsKey(depth)){
            map.get(depth).add(root.val);
        }else{
            ArrayList<Integer> list = new ArrayList<>();
            list.add(root.val);
            map.put(depth, list);
        }
        populateMap(root.left, map, depth + 1);
        populateMap(root.right, map, depth + 1);
    }
}
