// one pass - fast/slow pointers
// time: O(n)
// space: O(1)

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

// two pass
// time: O(n)
// space: O(1)
class Solution {
    public ListNode middleNode(ListNode head) {
        int n = 0;
        for (ListNode node = head; node != null; node = node.next)
            n++;
        for (int i = 0; i < n / 2; i++)
            head = head.next;
        return head;
    }
}
