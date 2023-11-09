class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode newHead = null;
        if (head.next == null) {
            newHead = head;
        } else {
            newHead =  reverseList(head.next);
            head.next.next = head;
            head.next = null;
        }
        
        return newHead;
    }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode prev=null, cur=head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
