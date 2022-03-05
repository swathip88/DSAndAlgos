//https://leetcode.com/problems/copy-list-with-random-pointer/submissions/
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class CopyListWIthRandomPointers {
    public Node copyRandomList(Node head) {
        Node t = head;
        if(t == null){
            return head;
        }
        while(t !=null){
            Node newNode = new Node(t.val);
            newNode.next = t.next;
            t.next = newNode;
            t = t.next.next;
        }
        
        t = head;
        while(t!=null){
            if(t.next!=null){
                t.next.random = (t.random!=null ? t.random.next: t.random);    
            }
            
            t = t.next.next;
        }
        
        Node ans = head.next;
        t = head;
        while(t!=null){
            Node newNode = t.next;
            t.next = t.next.next;
            newNode.next = newNode.next!=null? newNode.next.next: newNode.next ;
            t = t.next;
        }
        
        return ans;
        
    }
}
