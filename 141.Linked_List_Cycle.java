// slow/fast pointers
// time: O(n)
// space: O(1)
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
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow == fast;
    }
}
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = new ListNode();
        slow.next = head;
        ListNode fast = head;
        while (slow != fast && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow == fast;
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
