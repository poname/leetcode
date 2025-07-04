class LRUCache {

    Node first, last;
    Map<Integer, Node> map;
    int cap = 0;

    public LRUCache(int capacity) {
        first = new Node();
        last = new Node();
        first.next = last;
        last.prev = first;
        map = new HashMap<>();
        cap = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            addAfterFirst(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            node.val = value;
            addAfterFirst(node);
        } else {
            if (cap == 0) {
                map.remove(last.prev.key);
                remove(last.prev);
                cap++;
            }
            Node node = new Node();
            node.key = key;
            node.val = value;
            addAfterFirst(node);
            cap--;
            map.put(key, node);
        }
    }

    void remove(Node head) {
        Node l = head.prev;
        Node r = head.next;
        l.next = r;
        r.prev = l;
    }

    void addAfterFirst(Node node) {
        node.next = first.next;
        node.prev = first;
        first.next.prev = node;
        first.next = node;
    }
}

class Node {
    int key;
    int val;
    Node prev;
    Node next;
}
