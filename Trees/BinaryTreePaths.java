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
class BinaryTreePaths {
    //https://leetcode.com/problems/binary-tree-paths/submissions/
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> ans = new ArrayList<>();
        if(root ==null){
            return null;
        }else{
            TreeNode temp = root;
            traverse(temp, "" + root.val, ans);
        }
        return ans;
    }
    
    private void traverse(TreeNode temp, String str, ArrayList<String> ans){
        if(temp.left == null && temp.right == null){
            ans.add(str);
            return;
        }
        else{
            if(temp.left !=null){
                String newStr = str + "->" + temp.left.val;
                traverse(temp.left, newStr, ans);
            }
            if(temp.right !=null){
                String newStr = str + "->" + temp.right.val;
                traverse(temp.right, newStr, ans);
            }
        }
    }
}
