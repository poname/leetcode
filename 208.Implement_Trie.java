// time: O(k)
// space: insert -> O(k) | search -> O(1) | startsWith -> O(1)
// k: word/prefix length

// map
class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node head = root;
        for (char c : word.toCharArray()) {
            if (head.map.get(c) == null) {
                head.map.put(c, new Node());
            }
            head = head.map.get(c);
        }
        head.word = true;
    }

    public boolean search(String word) {
        Node head = root;
        for (char c : word.toCharArray()) {
            if (head.map.get(c) == null) {
                return false;
            }
            head = head.map.get(c);
        }
        return head.word;
    }

    public boolean startsWith(String prefix) {
        Node head = root;
        for (char c : prefix.toCharArray()) {
            if (head.map.get(c) == null) {
                return false;
            }
            head = head.map.get(c);
        }
        return true;
    }
}

class Node {
    Map<Character, Node> map;
    boolean word;

    public Node() {
        this.map = new HashMap<>();
        word = false;
    }
}

// array
class Trie {

    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node head = root;
        for (char c : word.toCharArray()) {
            if (head.children[c - 'a'] == null) {
                head.children[c - 'a'] = new Node();
            }
            head = head.children[c - 'a'];
        }
        head.word = true;
    }

    public boolean search(String word) {
        Node head = root;
        for (char c : word.toCharArray()) {
            if (head.children[c - 'a'] == null) {
                return false;
            }
            head = head.children[c - 'a'];
        }
        return head.word;
    }

    public boolean startsWith(String prefix) {
        Node head = root;
        for (char c : prefix.toCharArray()) {
            if (head.children[c - 'a'] == null) {
                return false;
            }
            head = head.children[c - 'a'];
        }
        return true;
    }
}

class Node {
    Node[] children;
    boolean word;

    public Node() {
        this.children = new Node[26];
        word = false;
    }
}
