/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class NAryLevelOrder {
    //https://leetcode.com/problems/n-ary-tree-level-order-traversal/submissions/
    public List<List<Integer>> levelOrder(Node root) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        levelOrder(root, 0, map);
        
        return new ArrayList<List<Integer>>(map.values());
    }
    
    public void levelOrder(Node root, int level, HashMap<Integer, ArrayList<Integer>> map){
        if(root == null){
            return;
        }
        int val = root.val;
        if(map.containsKey(level)){
            map.get(level).add(val);
        }else{
            ArrayList<Integer> list = new ArrayList<>();
            list.add(val);
            map.put(level, list);
        }
        List<Node> kids = root.children;
        for(Node n: kids){
            levelOrder(n, level+1, map);
        }
    }
}
