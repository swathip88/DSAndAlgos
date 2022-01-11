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
class RemoveNthFromLast {
    //https://leetcode.com/problems/remove-nth-node-from-end-of-list/submissions/
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        if(head == null){
            return null;
        }
        
        for(int i=1;i<=n;i++){
           temp = temp.next;
        }
        
        //if remove the first node
    if(temp == null){
        head = head.next;
        return head;
    }
        ListNode ans = head;
        ListNode prev = ans;
        while(temp !=null){
            prev = ans;
            ans = ans.next;
            temp = temp.next;
        }
        
        prev.next = ans.next;
        return head;
    }
}
