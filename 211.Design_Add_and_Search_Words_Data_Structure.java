// time: O(k) ... O(26^k) for 0 to k wildcards 
// space: insert -> O(k) 
//        search -> O(k) size of the call stack

// if search is written with a loop then
// space: insert -> O(k) 
//        search -> O(1) when no wildcard and O(k) when all wildcard: size of the call stack
    boolean dfs(Node head, String word, int idx) {
        if (idx >= word.length()) {
            return head.word;
        }
        char c = word.charAt(idx);
        if (c == '.') {
            for (Node child : head.children) {
                if (child != null && dfs(child, word, idx + 1)) {
                    return true;
                }
            }
        } else {
            if (head.children[c - 'a'] != null) {
                return dfs(head.children[c - 'a'], word, idx + 1);
            }
        }
        return false;
    }

class WordDictionary {
    Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
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
        return dfs(root, word, 0);
    }

    boolean dfs(Node head, String word, int idx) {
        if (idx >= word.length()) {
            return head.word;
        }
        char c = word.charAt(idx);
        if (c == '.') {
            for (Node child : head.children) {
                if (child != null && dfs(child, word, idx + 1)) {
                    return true;
                }
            }
        } else {
            if (head.children[c - 'a'] != null) {
                return dfs(head.children[c - 'a'], word, idx + 1);
            }
        }
        return false;
    }
}

class Node {
    Node[] children = new Node[26];;
    boolean word = false;
}
