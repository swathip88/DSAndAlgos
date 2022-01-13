/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class LowestCommonAncestorBinaryTree {
    //https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/submissions/
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return getLCA(root, p, q);
    }
    
    private TreeNode getLCA(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return null;
        }
        
        if(root.val == p.val || root.val == q.val){
            return root;
        }
        
        TreeNode t1 = getLCA(root.left, p, q);
        TreeNode t2 = getLCA(root.right, p, q);
        
        if(t1!=null && t2!=null){
            return root;
        }
        
        return t1!=null ? t1 : t2;
    }
}
