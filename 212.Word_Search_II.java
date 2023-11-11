// O(mn * 4^(mn))
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.add(word);
        }
        Set<String> set = new HashSet<>();
        for (int r=0; r<board.length; r++) { // O(m)
            for (int c=0; c<board[0].length; c++) { // O(n)
                dfs(r, c, trie.head, set, board, new boolean[board.length][board[0].length]); // O(4^(mn))
            }
        }
        List<String> res = new ArrayList<>();
        for (String s : set) {
            res.add(s);
        }
        return res;
    }
    void dfs(int r, int c, Node head, Set<String> res, char[][] board, boolean[][] visited) {
        if (r<0 || r>=board.length || c<0 || c>=board[0].length || head.next[board[r][c]-'a']==null || visited[r][c]) {
            return;
        }
        visited[r][c] = true;
        Node next = head.next[board[r][c]-'a'];
        if (next.isWord) {
            res.add(next.word);
        }
        dfs(r+1, c, next, res, board, visited);
        dfs(r-1, c, next, res, board, visited);
        dfs(r, c+1, next, res, board, visited);
        dfs(r, c-1, next, res, board, visited);
        visited[r][c] = false;
    }
}

class Trie {
    public final Node head;

    public Trie() {
        head = new Node();
    }

    public void add(String word) {
        Node node = head;
        for (char c : word.toCharArray()) {
            if (node.next[c-'a'] == null) {
                node.next[c-'a'] = new Node();
            }
            node = node.next[c-'a'];
        }
        node.isWord = true;
        node.word = word;
    }
}

class Node {
    Node[] next = new Node[26];
    boolean isWord;
    String word;
}
