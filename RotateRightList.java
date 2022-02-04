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
class RotateRightList {
    //https://leetcode.com/problems/rotate-list/submissions/
    public ListNode rotateRight(ListNode head, int k) {
        
        if(head == null){
            return head;
        }
        ListNode temp = head;
        for(int i=0;i<k;i++){
            
            temp = temp.next;
            if(temp == null){
                temp = head;
            }
        }
        
        ListNode newHead = head;
        while(temp !=null && temp.next !=null){
            temp = temp.next;
            newHead = newHead.next;
        }
        
        temp.next = head;
        head = newHead.next;
        newHead.next = null;
        return head;
    }
}
