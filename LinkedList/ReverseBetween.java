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
class ReverseBetween {
    //https://leetcode.com/problems/reverse-linked-list-ii/submissions/
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode prev = null;
        ListNode cur = head;
        if(head == null){
            return null;
        }
        
        while(left>1){
            prev = cur;
            cur = cur.next;
            left--;
            right--;
        }
        
        ListNode con = prev, tail = cur;
        ListNode third = null;
        while(right>0){
            third = cur.next;
            cur.next = prev;
            prev = cur;
            cur = third;
            right--;
        }
        if(con!=null){
            con.next = prev;
        }else{
            head = prev;
        }
        
        tail.next = cur;
        return head;
    }
}
