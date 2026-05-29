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
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head==null) return null;
        ListNode cur=head;
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode prev=dummy;
        while(cur!=null&&cur.next!=null){
            ListNode nextPair=cur.next.next;
            ListNode second=cur.next;
            second.next=cur;
            cur.next=nextPair;
            prev.next=second;
            prev=cur;
            cur=nextPair;
        }
        return dummy.next;
    }
}