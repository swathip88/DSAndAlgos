/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class CloneGraph {
    //https://leetcode.com/problems/clone-graph/submissions/
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        LinkedList<Node> queue = new LinkedList<>();
        HashMap<Node, Node> map = new HashMap<>();
        
        queue.add(node);
        
        Node ans = createNode(node);
        Node temp = ans;
        map.put(node, ans);
        
        while(!queue.isEmpty()){
            Node n = queue.remove();
            List<Node> neighbors = n.neighbors;
            
            for(int i=0;i<neighbors.size();i++){
                if(!map.containsKey(neighbors.get(i))){
                    Node newNode = createNode(neighbors.get(i));
                    map.put(neighbors.get(i), newNode);
                    queue.add(neighbors.get(i));
                }else{
                    
                }
                map.get(n).neighbors.add(map.get(neighbors.get(i)));
            }
            
        }
        
        return ans;
    }
    
    private Node createNode(Node node){
        Node newNode = new Node(node.val);
        return newNode;
    }
}
