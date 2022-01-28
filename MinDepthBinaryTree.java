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
class MinDepthBinaryTree {
    //https://leetcode.com/problems/minimum-depth-of-binary-tree/submissions/
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if (root.left == null)
            return minDepth(root.right) + 1;
 
        // If right subtree is NULL, recur for left subtree
        if (root.right == null)
            return minDepth(root.left) + 1;
 
        return Math.min(minDepth(root.left),
                        minDepth(root.right)) + 1;
    }
}
