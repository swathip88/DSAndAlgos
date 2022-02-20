/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class ReorderList {
    //https://leetcode.com/problems/reorder-list/submissions/
    public void reorderList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while(temp!=null){
            stack.add(temp);
            temp = temp.next;
        }
        
        temp = head;
        while(temp !=null){
            ListNode nextNode = temp.next;
            ListNode endNode = stack.pop();
            temp.next = endNode;
            endNode.next = nextNode;
            temp = nextNode;
            if(temp !=null && temp.next == endNode){
                temp.next = null;
                break;
            }
        }
    }
}
