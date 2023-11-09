class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode left = dummy;
        ListNode right = head;

        while (n > 0) {
            right = right.next;
            n--;
        }

        while (right != null) {
            left = left.next;
            right = right.next;
        }

        left.next = left.next.next;
        
        return dummy.next;
    }
}

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
