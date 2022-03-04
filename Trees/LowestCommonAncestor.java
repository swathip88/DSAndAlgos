/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    //https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/submissions/
    private TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recurse(root, p, q); 
        return ans;
    }   
    
    private boolean recurse(TreeNode root, TreeNode p, TreeNode q){
        int mid =0;
        
        if(root == null) return false;
        
        int left = recurse(root.left , p, q)? 1:0;
        int right = recurse(root.right , p, q)? 1:0;
        
        if(root == p || root == q){
            mid = 1;    
        }else{
            mid = 0;
        }
        
        if(mid + left + right >=2){
            this.ans = root;
        }
        
        return mid + left + right >0;
    }
}
