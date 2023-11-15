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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right = reverse(slow.next);
        slow.next = null;
        ListNode left = head;
        while (left != null && right != null) {
            ListNode nextL = left.next;
            ListNode nextR = right.next;
            left.next = right;
            right.next = nextL;
            left = nextL;
            right = nextR;
        }
    }
    ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}

class Solution {
    public void reorderList(ListNode head) {
        List<ListNode> nodes = new ArrayList<>();
        for (ListNode curr=head; curr!=null; curr=curr.next) {
            nodes.add(curr);
        }
        int l = 0;
        int r = nodes.size()-1;
        while (l < r) {
            nodes.get(l).next = nodes.get(r);
            l++;
            if (l == r) {
                nodes.get(l).next = null;
                break;
            }
            nodes.get(r).next = nodes.get(l);
            r--;
            if (l == r) {
                nodes.get(l).next = null;
                break;
            }
        }
    }
}
