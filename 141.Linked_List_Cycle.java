public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        
        while (fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }

        return false;
    }
}

public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        for (ListNode curr=head; curr!=null; curr=curr.next) {
            if (set.contains(curr)) {
                return true;
            }
            set.add(curr);
        }
        return false;
    }
}
