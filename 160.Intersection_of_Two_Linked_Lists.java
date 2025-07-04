// one pass
// time: O(m + n)
// space: O(1)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ptrA = headA;
        ListNode ptrB = headB;
        while (ptrA != ptrB) {
            ptrA = ptrA != null ? ptrA.next : headB;
            ptrB = ptrB != null ? ptrB.next : headA;
        }
        return ptrA;
    }
}

// two pass
// time: O(m + n)
// space: O(1)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        ListNode curA = headA;
        while (curA != null) {
            lenA++;
            curA = curA.next;
        }
        int lenB = 0;
        ListNode curB = headB;
        while (curB != null) {
            lenB++;
            curB = curB.next;
        }
        if (lenB > lenA) {
            for (int i = 0; i < (lenB - lenA); i++) {
                headB = headB.next;
            }
        }
        if (lenA > lenB) {
            for (int i = 0; i < (lenA - lenB); i++) {
                headA = headA.next;
            }
        }
        while (headA != null && headB != null) {
            if (headA == headB)
                return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
