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
class SameSubTree {
    //https://leetcode.com/problems/subtree-of-another-tree/
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root== null) return false;
        queue.add(root);
        
        while(!queue.isEmpty()){
            TreeNode t = queue.poll();
            
            boolean b = isSame(t, subRoot);
            if(b) return true;
            
            if(t.left !=null) queue.add(t.left);
            if(t.right !=null) queue.add(t.right);
        }
        
        return false;
    }
    
    
    
    private boolean isSame(TreeNode t1, TreeNode t2){
        if(t1==null && t2 ==null){
            return true;
        }
        if(t1==null){
            return false;
        }
        if(t2==null){
            return false;
        }
        
        if(t1.val != t2.val){
            return false;
        }
        
        return isSame(t1.left, t2.left) && isSame(t1.right, t2.right);
    }
}
