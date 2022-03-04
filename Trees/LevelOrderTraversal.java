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
class LevelOrderTraversal {
    //https://leetcode.com/problems/binary-tree-level-order-traversal/submissions/
    public List<List<Integer>> levelOrder(TreeNode root) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        levelOrder(root, 0, map);
        
        return new ArrayList<List<Integer>>(map.values());
    }
    
    public void levelOrder(TreeNode root, int level, HashMap<Integer, ArrayList<Integer>> map){
        if(root == null){
            return;
        }
        int val = root.val;
        if(map.containsKey(level)){
            map.get(level).add(val);
        }else{
            ArrayList<Integer> list = new ArrayList<>();
            list.add(val);
            map.put(level, list);
        }
        levelOrder(root.left, level + 1, map);
        levelOrder(root.right, level + 1, map);
    }
}
