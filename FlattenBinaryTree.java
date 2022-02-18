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
class FlattenBinaryTree {
    //https://leetcode.com/problems/flatten-binary-tree-to-linked-list/submissions/
    public void flatten(TreeNode root) {
        flat(root);
    }
    
    private void flat(TreeNode root){
        if(root == null){
            return;
        }
        flat(root.left);
        flat(root.right);
        
        if(root.left ==null && root.right ==null){
            return;
        }
        
        TreeNode temp = root.right;
        if(root.left!=null){
            root.right = root.left;
            TreeNode cur = root;
            while(cur.right !=null){
                cur = cur.right;
            }
            cur.right = temp;
            root.left = null;
        }
        
    }
}
