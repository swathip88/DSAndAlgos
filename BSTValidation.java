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
class BSTValidation {
    //https://leetcode.com/problems/validate-binary-search-tree/submissions/
    public boolean isValidBST(TreeNode root) {
        return isBSTHelper(root, null, null);
    }
    public boolean isBSTHelper(TreeNode node, Integer lowerLim, Integer upperLim) {
        if (lowerLim != null && node.val <= lowerLim) return false;
        if (upperLim != null && upperLim <= node.val) return false;

        boolean isLeftBST = true;
        boolean isRightBST = true;

        if (node.left != null) {
            isLeftBST = isBSTHelper(node.left, lowerLim, node.val);
        }
        
        if (node.right != null) {
            isRightBST = isBSTHelper(node.right, node.val, upperLim);
        }

        return isLeftBST && isRightBST;
    }
}
