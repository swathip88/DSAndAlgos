/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    //https://leetcode.com/problems/serialize-and-deserialize-binary-tree/submissions/
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String ans = "";
        Queue<TreeNode> q = new LinkedList<>();
        if (root !=null){
            q.add(root);
        }else{
            return ans;
        }
        
        while(!q.isEmpty()){
            TreeNode node = q.remove();
            if(node == null){
                ans = ans + "null" + ",";
            }else{
                ans = ans + node.val + ",";
            }   
            if(node!=null){
                TreeNode left = node.left;
                TreeNode right = node.right;
                q.add(left);
                q.add(right);        
            }
        }
        
        while(ans.endsWith("null,")){
            ans = ans.substring(0, ans.length() - 5);
        }
        if(ans.endsWith(",")){
            ans = ans.substring(0, ans.length() - 1);
        }
        
        return ans;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")){
            return null;
        }
        String[] arr = data.split(",");
        
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = null;
        int i=0;
        while(i<arr.length){
            String str= arr[i];
            if(q.isEmpty()){
                if(str.equals("null")){
                    return null;
                }
                TreeNode t = new TreeNode(Integer.parseInt(str));
                root = t;
                q.add(t);
                i++;
            }else{
                TreeNode r = q.remove();
                if(str.equals("null")){
                    r.left = null;
                }else{
                    TreeNode node = new TreeNode(Integer.parseInt(str));
                    r.left = node;
                    q.add(node);
                }
                i++;
                if(i < arr.length){
                    String rStr = arr[i];
                    if(rStr.equals("null")){
                        r.right = null;
                    }else{
                        TreeNode node = new TreeNode(Integer.parseInt(rStr));
                        r.right = node;
                        q.add(node);
                    }
                    i++;
                }
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
