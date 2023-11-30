/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        for (Node h=head; h!=null; h=h.next) {
            map.putIfAbsent(h, new Node(h.val));
            if (h.next != null) {
                map.putIfAbsent(h.next, new Node(h.next.val));
                map.get(h).next = map.get(h.next);
            }
            if (h.random != null) {
                map.putIfAbsent(h.random, new Node(h.random.val));
                map.get(h).random = map.get(h.random);
            }
        }
        return map.get(head);
    }
}
