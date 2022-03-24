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
class DiameterOfBinaryTree {
    //https://leetcode.com/problems/diameter-of-binary-tree/submissions/
    private int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        
        getDiameter(root);
        
        return ans;
    }
    
    public int getDiameter(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int lHeight = getDiameter(root.left);
        int rHeight = getDiameter(root.right);
        int maxDiameter = lHeight + rHeight;
        ans = Math.max(ans, maxDiameter);
        return Math.max(lHeight, rHeight) + 1;
        
    }
}
