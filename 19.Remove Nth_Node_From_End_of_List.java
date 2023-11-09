class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        for(ListNode curr=head; curr!=null; curr=curr.next) {
            count++;
        }
            int diff = count-n;
        ListNode curr=head;
        ListNode prev=null;
        while (diff > 0) {
            prev = curr;
            curr = curr.next;
            diff--;
        }
        if (prev != null) {
            prev.next = curr.next;
        } else {
            head = curr.next;
        }
    
        return head;
    }
}
