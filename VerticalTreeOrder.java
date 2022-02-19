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
class VerticalTreeOrder {
    //https://leetcode.com/problems/binary-tree-vertical-order-traversal/submissions/
    public List<List<Integer>> verticalOrder(TreeNode root) {
        int col = 0;
        int depth = 0;
        if(root ==null){
            return new ArrayList<>();
        }
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        Queue<Pair<TreeNode, Pair<Integer, Integer>>> queue = new ArrayDeque();
        queue.offer(new Pair(root, new Pair(col, depth)));
        
        while(!queue.isEmpty()){
            Pair<TreeNode, Pair<Integer, Integer>> pair = queue.poll();
            TreeNode node = pair.getKey();
            int tempCol = pair.getValue().getKey();
            int tempDepth = pair.getValue().getValue();
            
            if(map.containsKey(tempCol)){
                map.get(tempCol).add(node.val);
            }else{
                ArrayList<Integer> l = new ArrayList<>();
                l.add(node.val);
                map.put(tempCol, l);
            }
            
            if(node.left !=null){
                queue.offer(new Pair (node.left, new Pair(tempCol - 1, tempDepth +1)));
            }
            if(node.right !=null){
                queue.offer(new Pair(node.right, new Pair(tempCol + 1, tempDepth +1)));
            }
        }
        
        List<Integer> sortedKeys = map.keySet().stream().sorted().collect(Collectors.toList());
        ArrayList<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<sortedKeys.size();i++){
            ans.add(map.get(sortedKeys.get(i)));
        }
        
        return ans;
    }
}
