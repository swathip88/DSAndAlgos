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
class AddTwoNumbers {
   // https://leetcode.com/problems/add-two-numbers
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        int carry = 0;
        
        ListNode head = null;
        ListNode cur = null;
    
        while(l1 != null && l2 !=null){
            int no1 = l1.val;
            int no2 = l2.val;
            int sum = no1 + no2 + carry;
            if(sum >= 10){
                carry = 1;
                sum = sum - 10;
            }else{
                carry = 0;
            }
            
            ListNode newNode = new ListNode(sum);
            if(head == null || cur == null){
                head = newNode;
                cur = head;
            }else{
                cur.next = newNode;
                cur = newNode;
            }
            l1 = l1.next;
            l2 = l2.next;
            
        }
        
        if(l1 != null){
            while(l1 != null){
                int sum = l1.val + carry;
                if(sum >= 10){
                    carry = 1;
                    sum = sum - 10;
                }else{
                    carry = 0;
                }
                ListNode newNode = new ListNode(sum);
                cur.next = newNode;
                cur = newNode;
                l1 = l1.next;
            }
        }
        
        if(l2 != null){
            while(l2 != null){
                int sum = l2.val + carry;
                if(sum >= 10){
                    carry = 1;
                    sum = sum - 10;
                }else{
                    carry = 0;
                }
                ListNode newNode = new ListNode(sum);
                cur.next = newNode;
                cur = newNode;
                l2 = l2.next;
            }
        }
        
        //Add last node if needed
        if(carry == 1){
            cur.next = new ListNode(1);
        }
        
        return head;
    }
}
