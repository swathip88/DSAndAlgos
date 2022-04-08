/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class PopulatingNextPointer {
    //https://leetcode.com/problems/populating-next-right-pointers-in-each-node/submissions/
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        
        if(root == null){
            return root;
        }
        Node head = root;    
        queue.add(head);
        
        while(!queue.isEmpty()){
            
            List<Node> nodes = new ArrayList<>();
            while(!queue.isEmpty()){
                nodes.add(queue.poll());
            }
            
            for(int i=0;i<nodes.size();i++){
                if(i==nodes.size() -1){
                    nodes.get(i).next = null;
                    if(nodes.get(i).left !=null){
                        queue.add(nodes.get(i).left);
                    }
                    
                    if(nodes.get(i).right !=null){
                        queue.add(nodes.get(i).right);
                    }
                }else{
                    nodes.get(i).next = nodes.get(i+1);    
                    if(nodes.get(i).left !=null){
                        queue.add(nodes.get(i).left);
                    }
                    
                    if(nodes.get(i).right !=null){
                        queue.add(nodes.get(i).right);
                    }
                }
            }
        }
        
        return root;
    }
}
