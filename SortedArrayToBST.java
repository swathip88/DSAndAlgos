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
class SortedArrayToBST {
    //https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/submissions/
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = helper(nums, 0, nums.length -1);
        return root;
    }
    
    private TreeNode helper(int[]nums, int left, int right){
        if(left > right) return null;
        
        int mid = (left + right)/2;
        
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, left, mid -1);
        node. right = helper(nums, mid+1, right);
        
        return node;
    }
}
