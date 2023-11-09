class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode tail = head;

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                tail.next = list2;
                list2 = list2.next;
            } else {
                tail.next = list1;
                list1 = list1.next;
            }
            tail = tail.next;
        }

        if (list1 != null) {
            tail.next = list1;
        }

        if (list2 != null) {
            tail.next = list2;
        }

        return head.next;
    }
}

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null;
        ListNode tail = null;

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                if (head == null) {
                    head = list2;
                    tail = list2;
                } else {
                    tail.next = list2;
                    tail = tail.next;
                }
                list2 = list2.next;
            } else {
                if (head == null) {
                    head = list1;
                    tail = list1;
                } else {
                    tail.next = list1;
                    tail = tail.next;
                }
                list1 = list1.next;
            }
            
        }

        if (list1 != null) {
            if (head == null) {
                head = list1;
            } else {
                tail.next = list1;
            }
        }

        if (list2 != null) {
            if (head == null) {
                head = list2;
            } else {
                tail.next = list2;
            }
        }

        return head;
    }
}
