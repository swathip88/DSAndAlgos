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
class TwoSumBSTs {
    //https://leetcode.com/problems/two-sum-bsts/
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        if(root1 == null || root2 == null){
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root1);
        
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            int newTarget = target - node.val;
            boolean found = search(root2, newTarget);
            if(found) return true;
            
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
        
        return false;
    }
    
    private boolean search(TreeNode root, int target){
        if(root == null){
            return false;
        }
        if(root.val == target){
            return true;
        }
        
        if(root.val < target){
            return search(root.right, target);
        }else{
            return search(root.left, target);
        }
    }
}
