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
class BSTIterator {
    //https://leetcode.com/problems/binary-search-tree-iterator/submissions/
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        controlledRecursion(root);
    }
    
    
    public int next() {
        TreeNode node= stack.pop();
        if(node.right !=null){
            controlledRecursion(node.right);
        }
        return node.val;
    }
    
    public boolean hasNext() {
        return stack.size() > 0;
    }
    
    private void controlledRecursion(TreeNode root){
        TreeNode temp = root;
        while(temp !=null){
            stack.add(temp);
            temp = temp.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
