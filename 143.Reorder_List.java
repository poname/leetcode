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
