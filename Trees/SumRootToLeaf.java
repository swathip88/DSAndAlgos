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
class SumRootToLeaf {
    //https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/solution/
    List<String> list = new ArrayList<String>();
    public int sumRootToLeaf(TreeNode root) {
        getPaths(root, new StringBuilder());
        List<String> temp = this.list;
        int sum =0;
        
        for(String a: this.list){
            sum+=convertBinToInt(a);
        }
        return sum;
    }
    
    private void getPaths(TreeNode root, StringBuilder res){
        if(root == null){
            return;
        }
        
        res.append(root.val);
        if(root.left == null && root.right == null){
            this.list.add(res.toString());
            if(res.length()>0){
                res.deleteCharAt(res.length()-1);    
            }
            return;
        }
        
        getPaths(root.left, res);
        
        
        getPaths(root.right, res);
        if(res.length()>0){
                res.deleteCharAt(res.length()-1);    
        }
    }
    
    private int convertBinToInt(String s){
        int sum =0;
        int pow = 0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i) == '1'){
                sum+= Math.pow(2, pow);
            }
            pow++;
        }
        return sum;
    }
}
