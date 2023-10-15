class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode head = root;
        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if (head.children[c-'a'] == null) {
                head.children[c-'a'] = new TrieNode();
            }
            head = head.children[c-'a'];
        }
        head.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode head = root;
        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            head = head.children[c-'a'];
            if (head == null) {
                return false;
            }
        }
        return head.isWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode head = root;
        for (int i=0; i<prefix.length(); i++) {
            char c = prefix.charAt(i);
            head = head.children[c-'a'];
            if (head == null) {
                return false;
            }
        }
        return true;
    }
}

class TrieNode {
    TrieNode[] children;
    boolean isWord;
    public TrieNode() {
        children = new TrieNode[26];
        isWord = false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
