// iterative
// time: O(n+m)
// space: O(1)
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode head = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                head.next = list1;
                list1 = list1.next;
            } else {
                head.next = list2;
                list2 = list2.next;
            }
            head = head.next;
        }
        if (list1 != null) {
            head.next = list1;
        }
        if (list2 != null) {
            head.next = list2;
        }
        return dummy.next;
    }
}

// recursive
// time: O(m+n)
// space: O(m+n)
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        rec(list1, list2, dummy);
        return dummy.next;
    }

    ListNode rec(ListNode list1, ListNode list2, ListNode head) {
        if (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                head.next = list1;
                return rec(list1.next, list2, head.next);
            } else {
                head.next = list2;
                return rec(list1, list2.next, head.next);
            }
        }
        if (list1 != null) {
            head.next = list1;
            return null;
        }
        if (list2 != null) {
            head.next = list2;
            return null;
        }
        return null;
    }
}
