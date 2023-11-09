class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length==0) {
            return null;
        }
        return merge(0, lists.length-1, lists);
    }

    ListNode merge(int start, int end, ListNode[] lists) {
        if (start == end) {
            return lists[start];
        }
        int mid = (start+end)/2;
        ListNode a = merge(start, mid, lists);
        ListNode b = merge(mid+1, end, lists);
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while (a != null && b != null) {
            if (a.val < b.val) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }
        if (a != null) {
            tail.next = a;
        }
        if (b != null) {
            tail.next = b;
        }
        return dummy.next;
    }
}
