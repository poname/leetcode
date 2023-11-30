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

        /**
        change A --> B --> C --> D
        to A --> A' --> B --> B' --> C --> C' --> D --> D'
         */
        for (Node h=head; h!=null; h=h.next.next) {
            Node c = new Node(h.val);
            c.next = h.next;
            h.next = c;
        }

        // keep A' as return value
        Node ans = head.next;

        // connect random for A', B', C', D' 
        for (Node h=head; h!=null; h=h.next.next) {
            h.next.random = h.random!=null ? h.random.next : null;
        }

        /**
        change A --> A' --> B --> B' --> C --> C' --> D --> D'
        to A --> B --> C --> D and A' --> B' --> C' --> D'
         */
        for (Node h=head; h!=null; h=h.next) {
            Node c = h.next;
            h.next = h.next!=null ? h.next.next : null;
            c.next = c.next!=null ? c.next.next : null;
        }

        return ans;
    }
}

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
