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
class KthLowestBST {
    //https://leetcode.com/problems/kth-smallest-element-in-a-bst/submissions/
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        TreeNode ans= getKthSmallest(root, k);
        if(ans!=null){
            return ans.val;
        }
        return -1;
    }
    
    private TreeNode getKthSmallest(TreeNode root, int k){
        if(root == null){
            return null;
        }
        
        TreeNode l = getKthSmallest(root.left, k);
        
        if(l!=null){
            return l;
        }
        count++;
        if(k==count){
            return root;
        } else{
            return getKthSmallest(root.right, k);   
        }
    }
}
